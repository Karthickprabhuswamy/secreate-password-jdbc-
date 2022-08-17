package com.ty.secreatepassword.controller;

import java.util.ArrayList;

import com.ty.secreatepassword.dao.SecreateDao;
import com.ty.secreatepassword.dto.SecreatePassword;

public class SaveAllPassword 
{
	public static void main(String[] args) {
		
		SecreatePassword password = new SecreatePassword();
		
		SecreateDao dao = new SecreateDao();
		
		ArrayList<SecreatePassword> list = new ArrayList<SecreatePassword>();
		
		 password.setUserid(1);
		 password.setName("github");
		 password.setKey("Shela#@7898");
		 password.setPassword("KA5784ZZyut");
		 password.setDiscription("AAAAAAABBBBBBAAAcCCCAA");
		 
		 list.add(password);
		 dao.saveAllPassword(list);
		 
		 System.out.println("Saved");
	}
	 
	
	
}
