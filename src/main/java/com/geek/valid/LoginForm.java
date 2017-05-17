package com.geek.valid;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message="用户名不能为空")
	private String uname;
	@NotEmpty(message="密码不能为空")
	private String passwd;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String name) {
		this.uname = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
}
