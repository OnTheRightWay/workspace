package com.lanou3g.homework;

public class Boss extends Person implements UserInter{
	public Boss(){}
	public Boss(String name,String userName,String password,String job){
		setJob(job);
		setName(name);
		setPassword(password);
		setUserName(userName);
	}
	public void fire(){
		System.out.println("老板解雇了一个人");
	}
	@Override
	public void onLine() {
		System.out.println("老板来公司了");
		this.fire();
	}
	@Override
	public void offLine() {
		System.out.println("老板离开公司了");
	}
	
}
