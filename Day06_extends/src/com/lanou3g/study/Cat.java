package com.lanou3g.study;

public class Cat {
	private String name;
	private Person onwer;
	
	/*
	 * ���췽�� ��
	 * 		1.��������������ͬ
	 * 		2.û�з���ֵ��һ����
	 * ���˹��췽������Ҫget/set��ʲô��
	 * ���ȵ�һ�㣬get��һ��Ҫ�еģ�����
	 * �����������޷����˽�����Եġ�
	 * 
	 * ����set��
	 * 		��Щ���ԣ�������ÿ������Ҫ���еģ�
	 * ����cat���ܻ���һ�����£���������ÿ��cat��
	 * ��ʼ����ʱ��������һ��������
	 * ���Կ����ٺ�����ʹ���У�ͨ��set����
	 * ��������һ��
	 * 		���ڳ�ʼ�����е����onwer���ԣ�
	 * ���п������è���Ժ����ˣ��Ǿ���Ҫ��ӭ���ˣ�
	 * ���ʱ��Ҳ����ʹ��set������ȥ�޸�����
	 */
	
	
	public Cat(Person onwer){
		//�������еĲ���onwer��ֵ
		//��ֵ��������onwer
		this.onwer = onwer;
	}

	public Person getOnwer() {
		return onwer;
	}

	public void setOnwer(Person onwer) {
		this.onwer = onwer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
