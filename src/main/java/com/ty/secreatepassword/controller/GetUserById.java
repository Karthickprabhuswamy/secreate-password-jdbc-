package com.ty.secreatepassword.controller;

import com.ty.secreatepassword.dao.UserDao;
import com.ty.secreatepassword.dto.User;

public class GetUserById {
	
	public static void main(String[] args) {
		
		User user =  new User();
		
		UserDao dao = new UserDao();
		
		User u = dao.getUserById(1);
		System.out.println(u);
	}
}
