package com.ty.secreatepassword.controller;

import com.ty.secreatepassword.dao.SecreateDao;
import com.ty.secreatepassword.dto.SecreatePassword;

public class UpdatePassWordByKey 
{

	public static void main(String[] args) {
		
		SecreateDao  dao =  new SecreateDao();
		
		SecreatePassword password = new SecreatePassword();
		
		password.setKey("KFCGH@##11");
		password.setPassword("Adf#@123#");
		dao.updatePassWords("KFCGH@##11", password);
	}	
}
