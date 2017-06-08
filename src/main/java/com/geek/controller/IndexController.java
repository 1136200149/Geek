package com.geek.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geek.domain.User;
import com.geek.repository.NavDao;
import com.geek.repository.QuestionDao;




@Controller
public class IndexController extends BaseController{
	
	
	@Resource
	private QuestionDao questiondao;
	
	
	@Resource
	private NavDao navdao;
	@RequestMapping("/") //主页入口
	public String index(Model model,HttpSession httpSession) {
		model.addAttribute("user",getSessionUser(httpSession));
		model.addAttribute("question", questiondao.FindAll());
		return "index";
	}
	
	
	
	
	
	

	
	 
	
	


	
	
	
}
