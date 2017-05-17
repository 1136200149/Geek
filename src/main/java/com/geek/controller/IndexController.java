package com.geek.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.geek.domain.Question;
import com.geek.repository.NavDao;
import com.geek.repository.QuestionDao;




@Controller
public class IndexController {
	
	
	@Resource
	private QuestionDao questiondao;
	
	
	@Resource
	private NavDao navdao;
	
	@RequestMapping("/") //主页入口
	public String index(Model model) {
		
		model.addAttribute("question", questiondao.FindAll());
		return "index";
	}
	
	
	
	
	
	

	
	
	
	


	
	
	
}
