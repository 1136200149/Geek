package com.geek.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Component;

import com.geek.domain.Comment;

@Transactional
@Component
public class CommentDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	public Comment findById(String id){
		DetachedCriteria query = DetachedCriteria.forClass(Comment.class)
				.add(Property.forName("id").eqProperty(id));
		return (Comment) query.getExecutableCriteria(getSession()).list().get(0); 
	}
	public void  add(Comment comment){
		getSession().save(comment);
	}
	public void delete(String id){
		
	}
	
	
}
