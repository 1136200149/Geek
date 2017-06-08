package com.geek.valid;





import com.geek.domain.Nav;


public class QuestionForm {


	private String content;

	private String title;

	private Nav nav = new Nav();
	



	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
