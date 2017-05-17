package com.geek.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.geek.repository.UserDao;
import com.geek.service.LoginService;
import com.geek.service.RegisterService;
import com.geek.valid.LoginForm;
import com.geek.valid.RegisterForm;





@Controller
public class UserController {
	
	@Resource
	private UserDao userdao;
	


	@RequestMapping("/login") //登陆入口
	public String login() {
		return "user/login";
	}

	
	@RequestMapping("/register") //注册入口
	public String register() {
		return "user/reg";
	}
	
	
	@ResponseBody//登陆入口
	@RequestMapping(value = "/login/check", method = RequestMethod.POST)
	public ModelAndView logincheck(@Valid LoginForm user,BindingResult Result,HttpSession httpSession,LoginService loginservice){
		ModelAndView mav= new ModelAndView("redirect:/login");
		loginservice.init(Result, user, httpSession,userdao);
		if(loginservice.getCount()>0){
			mav.addObject("error", loginservice.getErrorInfo()); //向前台输入错误信息
			return mav;
		}else{
			mav.setViewName("redirect:/");
			return mav; 
			
		}

	}
	
	
	@ResponseBody//注册入口
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public ModelAndView UserRegister(@Valid RegisterForm user,BindingResult Result,HttpSession httpSession,RegisterService registerservice){
		ModelAndView mav= new ModelAndView("redirect:/register");
		registerservice.init(Result, user, userdao);
		if(registerservice.getCount()>0){
			mav.addObject("error",registerservice.getErrorInfo());
			return mav;
		}
		registerservice.Registercast(user); //进行注册操作
		//mav.addObject("userid", user.getId());
		mav.setViewName("redirect:/login");
		return mav; 
	}
	
	@RequestMapping("/logout") //登出
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("user");  
		return "/index";
	}
	
	
	
	


	
	
	
}
