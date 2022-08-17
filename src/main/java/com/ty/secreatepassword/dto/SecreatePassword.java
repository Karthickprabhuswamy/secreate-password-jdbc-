package com.ty.secreatepassword.dto;

public class SecreatePassword {

	private int userid;
	private String name;
	private String key;
	private String password;
	private String discription;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDiscription()
	{
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}
	@Override
	public String toString() {
		return "\nSecreatePassword [userid=" + userid + ", name=" + name + ", key=" + key + ", password=" + password
				+ ", discription=" + discription + "]";
	}
}
