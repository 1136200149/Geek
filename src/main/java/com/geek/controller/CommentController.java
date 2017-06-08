package com.geek.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geek.domain.Comment;
import com.geek.domain.User;
import com.geek.repository.CommentDao;
import com.geek.service.CommentService;
import com.geek.valid.CommentForm;

@Controller
public class CommentController {
	@Resource 
	private CommentService commentService;
	@Resource
	private CommentDao commentDao;
	
	@ResponseBody
	@RequestMapping("/comment/add")
	public void add(HttpSession session,CommentForm form){
		User user = (User) session.getAttribute("user");
		commentService.addComment(form, user);
	}
	
	
	@GetMapping("/comment/delete")
	@ResponseBody
	public String delete(String commentid){
		commentDao.delete(commentid);
		return "true";
	}
	
	@GetMapping("/comment/findAll/{top_id}")
	public void findAll(@PathVariable String top_id){
		
	}
	
	
}
