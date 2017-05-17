package com.geek.valid;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.geek.domain.Nav;


public class QuestionForm {


	

	private String context;

	private String title;

	private Nav nav = new Nav();
	

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Nav getNav() {
		return nav;
	}

	public void setNav(Nav nav) {
		this.nav = nav;
	}

	
	
	
}
