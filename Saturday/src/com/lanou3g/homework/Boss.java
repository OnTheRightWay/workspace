package com.lanou3g.homework;

public class Boss extends Person implements UserInter{

	public Boss() {
		super();
		this.setJob("�ϰ�");
	}
	public void fire(){
		System.out.println("�ϰ�����һ����");
	}
	@Override
	public void onLine() {
		System.out.println("�ϰ�����˾��");
		this.fire();
	}
	@Override
	public void offLine() {
		System.out.println("�ϰ��뿪��˾��");
	}
	
}
