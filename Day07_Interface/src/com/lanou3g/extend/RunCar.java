package com.lanou3g.extend;

public class RunCar extends Car{
	//�ܳ��ļ��٣�Ӧ�ñ�һ��Ŀ�
	//�������Ǹ�д����Car�еļ��ٷ���
	//��д�����ǰѴӸ����м̳еķ����޸�
	@Override//ע�⣺���ע�����������Ǽ�⣬
			//speed�����Ƿ��ǴӸ���̳�����
	public void speed(){
		super.speed();
		System.out.println("���ٶ�Ϊ240");
	}
}
