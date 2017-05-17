package com.geek.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.geek.domain.Nav;
import com.geek.domain.Question;
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

	
	@RequestMapping(value = "/addquestion", method = RequestMethod.POST) //发布问题
	public ModelAndView addquestion(HttpSession httpSession,Model model,@Valid QuestionForm question) {
		User user = (User) httpSession.getAttribute("user");
		
		String userid = user.getId();
		String id = questiondao.Addquestion(question, userid);//
		return new ModelAndView("redirect:/detail/"+id);
		
	}
	
	
	
	@RequestMapping("/detail/{id}") //详情
	public String detail(Model model, @PathVariable String id,HttpSession httpSession) {
		Question question = questiondao.findById(id);
		model.addAttribute("question", question);
		
			return "jie/detail";
	}
	
	

	
	
}
