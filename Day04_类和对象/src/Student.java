
public class Student {
	
	//��������������
	//�������������Ի�û��ֵ��
	String name;
	String school;
	int id;
	
	public void play(){
		System.out.println(name+"����Ϸȥ��");
	}
	
	public void goToStudy(){
		System.out.println(name+"ȥ��ѧ�ˣ�ѧУ��"
				+school);
	}
	
	/*
	 * public 		Ȩ�����η�
	 * void			����ֵ����
	 * 			void��ʾ��û�з���ֵ
	 * show			������
	 * (String str) �����б��ǿ����ж��������
	 * 			String	�ǲ���������
	 * 				���÷�������Ҫ�����Ӧ���͵�����
	 * 			str		�ǲ���������
	 * 				������ģ�����ôд��ôд������Ҫ����֪��
	 * {}			�����壺���������������ʱ��Ҫִ�еĴ���
	 */
	public void show(String str){
		
	}
	
	public void ������(int money){
		System.out.println("������ʦ��Ǯ"+money+"ȥ����Ϸ��");
	}
	
	
	//�����ѧ���߱��ӷ����������
	public void add(int a,int b){
		int sum = a + b;
		System.out.println("��Ϊ��"+sum);
	}
	
	//public�����String
	//��ʾ����ֵ������String�����ַ���
	public String hot(String food){
		return "�����˵�"+food;
	}
}
