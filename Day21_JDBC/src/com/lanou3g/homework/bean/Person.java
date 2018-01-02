package com.lanou3g.homework.bean;

public class Person {
	private String name;
	private String userName;
	private String password;
	private String job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", job='" + job + '\'' +
				'}';
	}
}
