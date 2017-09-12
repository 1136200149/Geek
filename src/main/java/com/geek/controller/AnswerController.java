package com.geek.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geek.service.AnswerService;
import com.geek.valid.AnswerForm;

@Controller
public class AnswerController extends BaseController{
	
	@Resource 
	private AnswerService answerService;
	
	
	@ResponseBody
	@RequestMapping("/answer/add")
	public void add(AnswerForm form,HttpSession httpSession){
		answerService.save(form, getSessionUser(httpSession));
	}

}
