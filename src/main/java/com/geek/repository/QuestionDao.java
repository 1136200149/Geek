package com.geek.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.geek.domain.Question;
import com.geek.domain.User;
import com.geek.valid.QuestionForm;






@Repository
@Transactional

public class QuestionDao {
	@PersistenceContext
	private EntityManager EntityManager;
	
	public Session getSession(){
		return EntityManager.unwrap(org.hibernate.Session.class);	
	}
	
	/**
	 *  查询所有问题，按时间降序排序
	 * @return List<Question>
	 */
	public List<Question> FindAll(){
	    DetachedCriteria dc = DetachedCriteria.forClass(Question.class);
	    Criteria criteria = dc.getExecutableCriteria(getSession());
	    dc.addOrder(org.hibernate.criterion.Order.desc("ctime"));
	    List<Question> list = criteria.list();
	    return list;
	}
	
	
	/**
	 * 删除问题
	 * @param id
	 */
	public void DelectQuestion(String id){
		Question news=findById(id);
		getSession().delete(news);

	}
	
	public Question findById(String id) {
		return getSession().get(Question.class, id);
	}
	
	/**
	 * 添加问题
	 * @param questionForm
	 * @param user
	 * @return
	 */
	public String Addquestion(QuestionForm questionForm,User user) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		Question question = new Question();
		question.setId(uuid);//问题的id
		question.setUserid(user.getId());//用户id
		question.setCtime(new Timestamp(System.currentTimeMillis()));//创建时间
		question.setContent(questionForm.getContent());
		question.setTitle(questionForm.getTitle());
		question.setNav(questionForm.getNav());
		question.setUname(user.getUname());
		getSession().save(question);
		return uuid;
		
	}

	/**
	 * question表的views字段+1
	 * @param questionid
	 */

	public void addViews(String questionid) {
		int updatedEntities = getSession().createQuery(
			    "update Question " +
			    "set views = views +1 " +
			    "where id = :questionid" )
			.setParameter( "questionid", questionid )
			.executeUpdate();
	}
	/**
	 * question表的answers字段+1
	 * @param questionid
	 */
	public void addAnswer(String questionid) {
		int updatedEntities = getSession().createQuery(
			    "update Question " +
			    "set answers = answers +1 " +
			    "where id = :questionid" )
			.setParameter( "questionid", questionid )
			.executeUpdate();
		System.err.println(updatedEntities);
		
	}
	

	
	
	
	
	
	

}
