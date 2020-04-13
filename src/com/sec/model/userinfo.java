package com.sec.model;

public class userinfo {
	private int id;
	private String name;
	public userinfo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public userinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
