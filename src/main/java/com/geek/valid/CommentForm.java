package com.geek.valid;

import org.hibernate.validator.constraints.NotEmpty;

public class CommentForm {
		@NotEmpty(message="评论内容不能为空！")
		private String context;
		@NotEmpty(message="评论失败")
		private String questionid;
		
		
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getQuestionid() {
			return questionid;
		}
		public void setQuestionid(String questionid) {
			this.questionid = questionid;
		}
			
	}
