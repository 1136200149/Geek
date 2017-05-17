package com.geek.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import com.geek.domain.Nav;


@Repository
@Transactional
public class NavDao {
	@PersistenceContext
	private EntityManager EntityManager;
	
	public Session getSession(){
		return EntityManager.unwrap(org.hibernate.Session.class);	
	}
	
	public List<Nav> FindAll(){
	    DetachedCriteria dc = DetachedCriteria.forClass(Nav.class);
	    Criteria criteria = dc.getExecutableCriteria(getSession());
	    List<Nav> list = criteria.list();
	    return list;
	}
}
