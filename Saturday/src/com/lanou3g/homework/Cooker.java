package com.lanou3g.homework;

public class Cooker extends Person implements UserInter{
	public Cooker(){
		this.setJob("��ʦ");
	}
	public void dianShao(){
		System.out.println("��ʦ�����");
	}
	@Override
	public void onLine() {
		System.out.println("��ʦ��ʼ������");
		this.dianShao();
	}
	@Override
	public void offLine() {
		System.out.println("��ʦ�������");
	}
}
