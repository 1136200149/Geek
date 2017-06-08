package com.geek.valid;

import org.hibernate.validator.constraints.NotEmpty;

public class AnswerForm {
		@NotEmpty(message="评论内容不能为空！")
		private String content;
		@NotEmpty(message="评论失败")
		private String question_id;
		
		
	
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public String getQuestion_id() {
			return question_id;
		}
		public void setQuestion_id(String question_id) {
			this.question_id = question_id;
		}
		
			
		
	}
