package com.geek.domain;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Question {
	
	@Id
	private String id;
	private String userid;
	private String title;
	private String uname;
	private String content;
	private Timestamp ctime;
	private Integer views;
	private Integer answers;
	private Integer votes;
	
	@OneToOne
	@JoinColumn(name="navid")
	private Nav nav;

	public Question(){
		this.views = 0;
		this.answers = 0;
		this.votes = 0;
	}
		
	

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getUserid() {
			return userid;
		}

		public void setUserid(String userid) {
			this.userid = userid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUname() {
			return uname;
		}

		public void setUname(String uname) {
			this.uname = uname;
		}

		

		public String getContent() {
			return content;
		}



		public void setContent(String content) {
			this.content = content;
		}



		public Timestamp getCtime() {
			return ctime;
		}

		public void setCtime(Timestamp ctime) {
			this.ctime = ctime;
		}

		public Nav getNav() {
			return nav;
		}

		public void setNav(Nav nav) {
			this.nav = nav;
		}


		public Integer getViews() {
			return views;
		}

		public void setViews(Integer views) {
			this.views = views;
		}

		public Integer getAnswers() {
			return answers;
		}

		public void setAnswers(Integer answers) {
			this.answers = answers;
		}

		public Integer getVotes() {
			return votes;
		}

		public void setVotes(Integer votes) {
			this.votes = votes;
		}
		

	
	
}
