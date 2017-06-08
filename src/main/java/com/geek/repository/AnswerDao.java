package com.geek.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.geek.domain.Answer;
import com.geek.domain.Comment;


@Transactional
@Component
public class AnswerDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
	public void save(Answer answer){
		getSession().save(answer);
	} 
	
	
	/**
	 * 获取qestion_id下面所有答案，按时间排序
	 * @param question_id
	 * @return
	 */
	public List<Answer> findAll_ctime(String question_id){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Answer> query = builder.createQuery(Answer.class);
		Root<Answer> root = query.from(Answer.class);
		query.where(builder.equal(root.get("question_id"), question_id));
		query.orderBy(builder.desc(root.get("ctime")));
		List list  = entityManager.createQuery(query).getResultList();
		return list;
	}
	
	/**
	 * 获取qestion_id下面所有答案，按useful排序
	 * @param question_id
	 * @return
	 */
	public List<Answer> findAll_(String question_id){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Answer> query = builder.createQuery(Answer.class);
		Root<Answer> root = query.from(Answer.class);
		query.where(builder.equal(root.get("question_id"), question_id));
		query.orderBy(builder.desc(root.get("useful")));
		List list  = entityManager.createQuery(query).getResultList();
		return list;
	}
	
	
}
