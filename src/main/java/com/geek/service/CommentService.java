package com.geek.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.geek.domain.Comment;
import com.geek.domain.User;
import com.geek.repository.CommentDao;
import com.geek.valid.CommentForm;


@Component
public class CommentService {
	
	@Resource
	private CommentDao commentDao;
	
	/**
	 *  
	 * @param form
	 * @param user
	 */
	public void addComment(CommentForm form,User user){
		Comment comment = new Comment();
		comment.setUserid(user.getId());
		comment.setName(user.getUname());
		BeanUtils.copyProperties(form, comment, Comment.class);
		commentDao.add(comment);
		
	}
}
