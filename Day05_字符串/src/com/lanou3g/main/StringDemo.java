package com.lanou3g.main;

public class StringDemo {

	public static void main(String[] args) {
		/*
		 * String ��
		 * ��ʾ�ַ���
		 * ע�⣬�ַ������ǻ�����������
		 */
		//�ַ����ǲ��ɱ�ģ���һ���ַ�����������
		//���Ͳ����ٷ����仯
		String s3 = new String("����");
		String s4 = new String("����");
		String s1 = "����";
		String s2 = "����";
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		
		//equals���ַ����ķ���
		//ֻҪ���ַ�����������ʹ���������
		//���ܣ��ж������ַ����������Ƿ����
		boolean bo = s3.equals(s4);
		System.out.println(bo);
	}

}
