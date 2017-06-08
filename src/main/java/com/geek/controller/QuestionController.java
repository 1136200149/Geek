package com.geek.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.geek.domain.Answer;
import com.geek.domain.Comment;
import com.geek.domain.Nav;
import com.geek.domain.Question;
import com.geek.domain.User;
import com.geek.repository.AnswerDao;
import com.geek.repository.CommentDao;
import com.geek.repository.NavDao;
import com.geek.repository.QuestionDao;
import com.geek.repository.UserDao;
import com.geek.service.CommentService;
import com.geek.valid.QuestionForm;
import com.geek.valid.ValidSampleForm;



@Controller
public class QuestionController extends BaseController {
	@Resource
	private QuestionDao questionDao;
	
	@Resource
	private CommentDao commentDao;
	
	@Resource
	private AnswerDao answerDao;
	
	@Resource
	private UserDao userdao;
	
	@Resource
	private NavDao navdao;

	
	@RequestMapping("/add") //发布问题入口
	public String add(Model model,HttpSession httpSession) {
		List<Nav> list = navdao.FindAll();
		model.addAttribute("form", new QuestionForm());
		model.addAttribute("navs", list);
		model.addAttribute("user", getSessionUser(httpSession));
		return "add";
	}

	
	@RequestMapping(value = "/addquestion", method = RequestMethod.GET) //发布问题
	public String addquestion(HttpSession httpSession,Model model,@Valid QuestionForm question,BindingResult result) {
		String id = questionDao.Addquestion(question, getSessionUser(httpSession));//
		return "/add";
	}
	
	
	
	
	@RequestMapping(value="/validSample", method = RequestMethod.GET)  
    public String postValidSample(@ModelAttribute("form") @Validated ValidSampleForm form, BindingResult result, Model model) {  
   
  
        return "validSample";  
    }  
	
	
	@RequestMapping("/detail/{id}") //详情
	public String detail(Model model, @PathVariable String id,HttpSession httpSession) {
		Question question = questionDao.findById(id);
		questionDao.addViews(question.getViews() +1,id);
		List<Comment> comment = commentDao.findAll(id);
		List<Answer> answers = answerDao.findAll_ctime(id);
		model.addAttribute("user",getSessionUser(httpSession));
		model.addAttribute("answer" ,answers);
		model.addAttribute("question", question);
		model.addAttribute("comment", comment);
		return "detail";
	}
	
	
	
	

	
	
}
