
public class Main {
	public static void main(String args[]){
		
		//����Ǵ�������Ĺ���
		//Ȼ��������˵һ��ʲô�Ƕ���
		Car car=new Car();
		//������ǽ�car�ĵ�ַ������c2
		Car c2=car;
		c2.showInfo();
		//Car������
		//car���Ƕ���
//		�Ǹ���Car����ഴ��������
//		car.showInfo();
		System.out.println(car==c2);
	}
}
