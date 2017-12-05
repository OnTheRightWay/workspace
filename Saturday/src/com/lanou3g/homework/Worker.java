package com.lanou3g.homework;

public class Worker extends Person implements UserInter{
	public Worker(){
		this.setJob("工人");
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
