package com.geek.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.geek.domain.Nav;
import com.geek.domain.User;
import com.geek.repository.NavDao;
import com.geek.repository.QuestionDao;
import com.geek.repository.UserDao;
import com.geek.valid.QuestionForm;




@Controller
public class QuestionController {
	@Resource
	private QuestionDao questiondao;
	
	@Resource
	private UserDao userdao;
	
	@Resource
	private NavDao navdao;

	@RequestMapping("/add") //发布问题入口
	public String add(Model model) {
		List<Nav> list = navdao.FindAll();
		model.addAttribute("navs", list);
		
			return "jie/add";
		
		
	}

	
	@RequestMapping(value = "/addquestion", method = RequestMethod.POST) //创建问题
	public ModelAndView addquestion(HttpSession httpSession,Model model,@Valid QuestionForm question) {
		String userid=(String) httpSession.getAttribute("userid");
		questiondao.Addquestion(question, userid);//发布问题
	
		return new ModelAndView("redirect:/index");
		
	}
	

	
	
}
