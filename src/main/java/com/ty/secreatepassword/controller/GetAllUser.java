package com.ty.secreatepassword.controller;

import java.util.List;

import com.ty.secreatepassword.dao.UserDao;
import com.ty.secreatepassword.dto.User;

public class GetAllUser {
	
	
	public static void main(String[] args) {
		
		User user =  new User();
		
		UserDao dao = new UserDao();
		
		List<User> l = dao.getAllUser();
		System.out.println(l);	
	}

}
