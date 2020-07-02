package com.ssafy.model.dto;

public class User {
	private String userid;
	private String name;
	private String pass;
	private Integer balance;
	
	public User() {}

	public User(String userid, String name, String pass, Integer balance) {
		super();
		this.userid = userid;
		this.name = name;
		this.pass = pass;
		this.balance = balance;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", pass=" + pass + ", balance=" + balance + "]";
	}
}
