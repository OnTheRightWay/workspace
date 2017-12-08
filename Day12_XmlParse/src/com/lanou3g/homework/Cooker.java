package com.lanou3g.homework;

public class Cooker extends Person implements UserInter{
	public Cooker() {
	}

	public Cooker(String name, String userName, String password, String job){
		setJob(job);
		setName(name);
		setPassword(password);
		setUserName(userName);
	}
	public void dianShao(){
		System.out.println("厨师颠了几下勺子");
	}
	@Override
	public void onLine() {
		System.out.println("厨师开始做菜了");
		this.dianShao();
	}
	@Override
	public void offLine() {
		System.out.println("厨师做完菜了");
	}
}
