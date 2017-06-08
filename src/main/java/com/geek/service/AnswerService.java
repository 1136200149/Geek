package com.geek.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.geek.domain.Answer;
import com.geek.domain.User;
import com.geek.repository.AnswerDao;
import com.geek.valid.AnswerForm;

@Component
public class AnswerService {
	
	@Resource
	private AnswerDao answerDao;
	
	public void save(AnswerForm form ,User user){
		Answer answer = new Answer();
		answer.setUser(user);
		BeanUtils.copyProperties(form,answer, Answer.class);
		answerDao.save(answer);
	}
}
