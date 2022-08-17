package com.ty.secreatepassword.controller;

import com.ty.secreatepassword.dao.SecreateDao;

public class DeletePassWordByKey {

	public static void main(String[] args) {

		SecreateDao dao = new SecreateDao();

		dao.deletePassWordByKey("JEF#@68");

		System.out.println("deleted");
	}
}
