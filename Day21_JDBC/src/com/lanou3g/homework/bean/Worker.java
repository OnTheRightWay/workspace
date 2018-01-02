package com.lanou3g.homework.bean;

public class Worker extends Person implements UserInter {
	public Worker() {
	}

	public Worker(String name, String userName, String password, String job){
		setJob(job);
		setName(name);
		setPassword(password);
		setUserName(userName);
	}
	public void strike(){
		System.out.println("工人罢工");
	}
	@Override
	public void onLine() {
		System.out.println("工人开始干活了");
		this.strike();
	}
	@Override
	public void offLine() {
		System.out.println("工人干完活回家了");
	}
}
