package com.lanou3g.homework.bean;

public class Doctor extends Person implements UserInter {

	public Doctor() {
	}

	public Doctor(String name, String userName, String password, String job){

		setJob(job);
		setName(name);
		setPassword(password);
		setUserName(userName);
	}
	public void treat(){
		System.out.println("医生开药");
	}
	@Override
	public void onLine() {
		System.out.println("医生开始治病了");
		this.treat();
	}
	@Override
	public void offLine() {
		System.out.println("医生看完病了");
	}
	
}
