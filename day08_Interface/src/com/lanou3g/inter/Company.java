package com.lanou3g.inter;

public class Company {
	//Work��һ���ӿ�
	//������Ǵ�����һ���ӿڵ�����
	private Work work;

//	public Work getWork() {
//		return work;
//	}

	public void setWork(Work work) {
		this.work = work;
	}
	
	public void startWork(){
		//work����ӿڵ�����
		//��ָ��һ��ʵ�������
		//������ǵ������ʵ��������work����
		this.work.work();
	}
	public void endWork(){
		this.work.goHome();
	}
	
	
	
	
	
	
	
	
	
	
}
