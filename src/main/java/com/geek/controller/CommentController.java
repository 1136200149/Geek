package com.geek.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.geek.domain.Comment;
import com.geek.domain.User;
import com.geek.valid.CommentForm;

@Controller
public class CommentController {

	
	@GetMapping("/comment/add")
	public void add(HttpSession session,CommentForm form){
		
		User user = (User) session.getAttribute("user");
	}
	
	@PostMapping("/comment/delete/{id}")
	public void delete(@PathVariable String id){
		
	}
	
	@GetMapping("/comment/findAll/{top_id}")
	public void findAll(@PathVariable String top_id){
		
	}
	
	
}
