package com.lanou3g.change;

public class Main {

	public static void main(String[] args) {
		//���������ָ��������Ķ���
		Fruit fruit = new Apple();
		
//		fruit = new Banana();
		
		//��������ã�ֻ���ҵ�����ķ���
		//�Ҳ���������еķ���
		fruit.eat();
		if(fruit instanceof Apple){
			//����������ָ��Ķ���ΪApple
			//��ô���ǿ��Խ���ǿ������ת��
			
			//()��д�ľ���Ҫǿת������
			Apple  redApple = (Apple)fruit;
			redApple.drop();
		}
		
	}

}
