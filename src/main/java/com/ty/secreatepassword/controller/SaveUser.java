package com.ty.secreatepassword.controller;

import java.util.ArrayList;

import com.ty.secreatepassword.dao.UserDao;
import com.ty.secreatepassword.dto.User;

public class SaveUser {
	
	public static void main(String[] args) 
	{
		ArrayList<User> arrayList =  new ArrayList<User>();
		
		User user = new User();
		
		UserDao dao = new UserDao();
		
		user.setId(3);
		user.setName("Minku");
		user.setEmail("Minku@gmail.com");
		user.setPassword("Minku@123");
		
		arrayList.add(user);
		dao.saveAllUsers(arrayList);
		System.out.println("Data Saved");
	}

}
