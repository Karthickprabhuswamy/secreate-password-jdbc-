package com.ty.secreatepassword.controller;

import java.util.List;

import com.ty.secreatepassword.dao.UserDao;

public class GetSecreatePassword {
	
	public static void main(String[] args)
	{
		UserDao dao = new UserDao();
		
		List u = dao.getSecretePasswordbyId(1);
		System.out.println(u);
	}
}
