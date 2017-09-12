package com.geek.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.geek.domain.Answer;
import com.geek.domain.User;
import com.geek.repository.AnswerDao;
import com.geek.repository.QuestionDao;
import com.geek.valid.AnswerForm;

@Component
public class AnswerService {
	
	@Resource
	private AnswerDao answerDao;
	@Resource
	private QuestionDao questionDao;
	
	public void save(AnswerForm form ,User user){
		Answer answer = new Answer();
		answer.setUser(user);
		BeanUtils.copyProperties(form,answer, Answer.class);
		answerDao.save(answer);
		//更新问题答案数量
		questionDao.addAnswer(form.getQuestion_id());
	}
}
