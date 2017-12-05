package com.lanou3g.homework;

public class Doctor extends Person implements UserInter{

	public Doctor() {
		super();
		this.setJob("医生");
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
