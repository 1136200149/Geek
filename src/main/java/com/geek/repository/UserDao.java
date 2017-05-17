package com.geek.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.springframework.stereotype.Repository;

import com.geek.domain.User;
import com.geek.utils.MD5;



@Repository
@Transactional
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	public void SaveUser(User user){
		getSession().save(user);
	}
	
	public User findById(String id) {
		return getSession().get(User.class, id);
	}
	
	public boolean findByUserNameExist(String username) {
		boolean exist = true;
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Property.forName("uname").eq(username));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		if (criteria.list().size() == 0) exist = false;
		return exist;
	}
	
	public boolean findByEmailExist(String email) {
		boolean exist = true;
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Property.forName("mail").eq(email));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		if (criteria.list().size() == 0) exist = false;
		return exist;
	}
	
	public User checkPasswd(String uname,String passwd) {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Property.forName("uname").eq(uname));
		dc.add(Property.forName("passwd").eq(MD5.stringMD5(passwd)));
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<User> list = criteria.list();
		User user = new User();
		if (list.size() > 0) user = list.get(0);
		return user;	
	}
	
	public List<User> findAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		Criteria criteria = dc.getExecutableCriteria(getSession());
		List<User> list = criteria.list();
		return list;
	}
	
	public void DelectUser(String id){
		User user = findById(id);
		getSession().delete(user);
	}

	

	
	public void UpdateUser(User user){
		getSession().update(user);
	}
		
}
