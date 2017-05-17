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
	private String context;
	private Integer top;
	private Timestamp ctime;
	private String image;
	private String number;
	private String state;
	
		@OneToOne
		@JoinColumn(name="navid")
		private Nav nav;

		
		
		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
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

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}

		public Integer getTop() {
			return top;
		}

		public void setTop(Integer top) {
			this.top = top;
		}

		public Timestamp getCtime() {
			return ctime;
		}

		public void setCtime(Timestamp ctime) {
			this.ctime = ctime;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public Nav getNav() {
			return nav;
		}

		public void setNav(Nav nav) {
			this.nav = nav;
		}

		public Question() {
		}
		

	
	
}
