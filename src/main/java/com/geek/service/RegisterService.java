package com.geek.service;


import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.validation.BindingResult;

import com.geek.domain.User;
import com.geek.repository.UserDao;
import com.geek.utils.MD5;
import com.geek.valid.RegisterForm;





public class RegisterService {
	private int count = 0;
	private String Errorinfo;
	private UserDao userDao;
	public void init(BindingResult bindingResult, RegisterForm registerForm, UserDao userDao) {
		this.userDao=userDao;
		if(bindingResult.hasErrors()){
			setErrorInfo(bindingResult.getAllErrors().get(0).getDefaultMessage());
			this.plus();
			return;
		}
		checkPasswd(registerForm.getPasswd(), registerForm.getPasswd2());
		checkUserName(registerForm.getUname());
	}
	


	
	public void checkPasswd(String passwd,String confim_passwd) {
		if (!passwd.equals(confim_passwd)) {
			setErrorInfo("两次密码输入不一致");
			this.plus();
		}
	}
	
	public void checkUserName(String username) {
		if (userDao.findByUserNameExist(username)) {
			setErrorInfo("用户名已存在,请更换");
			this.plus();
		}
	}
	
	
	public void Registercast(RegisterForm registerForm) { //字符串拼接以及注册。
		User user = new User();
		user.setId(registerForm.getId()); //用户ID
		user.setUname(registerForm.getUname()); //用户账号
		user.setPasswd(MD5.stringMD5(registerForm.getPasswd())); //用户密码
		user.setMail(registerForm.getMail()); //用户邮箱
		user.setCtime(new Timestamp(System.currentTimeMillis()));
		userDao.SaveUser(user);
	}
	
	public void plus() {
		this.count++;
	}
		
	public int getCount() {
		return this.count;
	}
	public String getErrorInfo(){
		return this.Errorinfo;
	}
	public void setErrorInfo(String error){
		this.Errorinfo=error;
	}

}
