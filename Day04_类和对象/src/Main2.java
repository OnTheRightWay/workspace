
public class Main2 {
	
	//main�ǳ���������
	//��Java��������ʱ
	//�ͻ��ȴ����￪ʼִ��
	public static void main(String[] args){
		/*
		 * ���㴴������֮��
		 * ��Ҫ�ȴ������󣬲���ʹ��
		 */	
		Father father = new Father();

		//ʹ�ö��󣬵������ķ���ȥ��һЩ����
		//������.������();
		father.showInfo();

		//������.����
		System.out.println(father.name);

		Student zhangSan=new Student();
		//������.������ = ����ֵ��
		//����һ����ֵ����
		zhangSan.name="���϶�";
		zhangSan.school="��Ÿ�Ƽ���ӭ��";
		System.out.println(zhangSan.name);
		
		//���������÷���
		//ʹ��zhangSan�������
		//����play�������
		zhangSan.play();
		zhangSan.������(100);
		zhangSan.add(100,-300);
		
		//����������з���ֵ��
		//����ֵ������ΪString
		//�������ǿ��Զ���һ��String����
		//�ı���ȥ������������ķ���ֵ
		String f = zhangSan.hot("����");
		
		System.out.println(f);
	}
}
