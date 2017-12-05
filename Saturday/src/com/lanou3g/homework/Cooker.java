package com.lanou3g.homework;

public class Cooker extends Person implements UserInter{
	public Cooker(){
		this.setJob("厨师");
	}
	public void dianShao(){
		System.out.println("厨师会颠勺");
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
