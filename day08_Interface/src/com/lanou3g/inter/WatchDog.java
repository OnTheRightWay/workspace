package com.lanou3g.inter;

/**
 * �ĵ�ע��
 * WatchDog�࣬ͨ��implements�ؼ���
 * ��Work�ӿڲ����˹���������WatchDog��
 * ������Work����ӿڵĹ淶
 * 
 * implements�ؼ��֣�ʵ��
 * ͨ��implements�ؼ��֣�������һ����
 * ʵ�ֶ���ӿڣ�����ӿ�֮��ͨ�����ŷָ�
 * ������������࣬�����˽ӿڵĹ淶��
 * Ҳ��ʵ���˽ӿ�
 * 
 * A�̳���B����ôA�������࣬B��������
 * Aʵ����C����ôA����ʵ���࣬C�����ӿ�
 * 
 * 
 * 
 * @author ţ����
 *
 */
public class WatchDog implements Work{

	@Override
	public void work() {
		System.out.println("�ϸ��ˣ�˭��ҧ˭");
	}

	@Override
	public void goHome() {
		System.out.println("���ѳԹ�ͷ��");
	}
	
}
