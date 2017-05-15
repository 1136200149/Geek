package com.geek.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class IndexController {
	
	@RequestMapping("/") //主页入口
	public String index() {
		return "index";
	}

	
	
	@RequestMapping("/login") //登陆入口
	public String login() {
		return "user/login";
	}

	
	@RequestMapping("/register") //登陆入口
	public String register() {
		return "user/reg";
	}
	
	
	@RequestMapping("/add") //登陆入口
	public String add() {
		return "jie/add";
	}

	
	
	
}
