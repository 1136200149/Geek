package com.geek.controller;

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

import com.geek.domain.User;
import com.geek.repository.QuestionDao;
import com.geek.repository.UserDao;
import com.geek.valid.QuestionForm;




@Controller
public class QuestionController {
	@Resource
	private QuestionDao questiondao;
	
	@Resource
	private UserDao userdao;
	

	@RequestMapping("/add") //发布问题入口
	public String add(HttpSession httpSession) {
		if(checkAuth(httpSession)){
		return "jie/add";
		}
		return "404";
	}

	
	@RequestMapping(value = "/geek/addquestion", method = RequestMethod.POST) //创建问题
	public ModelAndView addquestion(HttpSession httpSession,Model model,@Valid QuestionForm question) {
		String userid=(String) httpSession.getAttribute("userid");
		questiondao.Addquestion(question, userid);//发布问题
	
		return new ModelAndView("redirect:/index");
		
	}
	
	
	public boolean checkAuth(HttpSession httpSession){  //权限检测
		String userid=(String) httpSession.getAttribute("userid");
		User user = new User();
		if(userid==null || userid ==""){ //如果userid为空或者不存在的话就可能是　用户退出　或者　session失效。
			return false;
		}else{
			user = userdao.findById(userid);
			if(user.getAuthority() < 0 || user.getAuthority()==0){
				return false;
			}else{
				return true; 
			}
		}
		
	} 
	
	
	
}
