package com.geek.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.geek.domain.Comment;

@Transactional
@Component
public class CommentDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Comment findById(String id){
		DetachedCriteria query = DetachedCriteria.forClass(Comment.class)
				.add(Property.forName("id").eq(id));
		return (Comment) query.getExecutableCriteria(getSession()).list().get(0); 
	}
	/**
	 * 
	 * @param taskId
	 * @return
	 */
	public List<Comment> findAll(String taskId){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Comment> query = builder.createQuery(Comment.class);
		Root<Comment> root = query.from(Comment.class);
		query.where(builder.equal(root.get("questionid"), taskId));
		List comment  = entityManager.createQuery(query).getResultList();
		return comment;
	}
	public void  add(Comment comment){
		getSession().save(comment);
	}
	public void delete(String id){
		getSession().delete(findById(id));
	}
	public void update(Comment comment){
		getSession().update(comment);
	}
	
	
}
