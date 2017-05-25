package com.geek.valid;

import org.hibernate.validator.constraints.NotEmpty;

public class CommentForm {
		@NotEmpty(message="评论内容不能为空！")
		private String content;
		@NotEmpty(message="评论失败")
		private String questionid;
		
		
	
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getQuestionid() {
			return questionid;
		}
		public void setQuestionid(String questionid) {
			this.questionid = questionid;
		}
			
	}
