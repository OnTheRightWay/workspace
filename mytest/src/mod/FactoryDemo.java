package mod;
//���󹤳�ģʽ
//interface Fruit{
//	public void eat();
//}
//
//class Apple implements Fruit{
//	public void eat(){
//		System.out.println("��ƻ��");
//	}
//}
//class Banana implements Fruit{
//	public void eat(){
//		System.out.println("���㽶");
//	}
//}
//class Cherry implements Fruit{
//	public void eat(){
//		System.out.println("��ӣ��");
//	}
//}
//interface Factory{
//	public Fruit buyFruit();
//}
//class AppleFactory implements Factory{
//	@Override
//	public Fruit buyFruit() {
//		return new Apple();
//	}
//}
//class BananaFactory implements Factory{
//	@Override
//	public Fruit buyFruit() {
//		return new Banana();
//	}
//}
//class CherryFactory implements Factory{
//	@Override
//	public Fruit buyFruit() {
//		return new Cherry();
//	}
//}
interface Fruit{
	void eat();
}
class Apple implements Fruit{
	public void eat(){
		System.out.println("�Ե���ƻ��");
	}
}
class Banana implements Fruit{
	public void eat(){
		System.out.println("�Ե����㽶");
	}
}
class Cherry implements Fruit{
	public void eat(){
		System.out.println("�Ե���ӣ��");
	}
}
interface Factory{
	Fruit getInstance();
}
class AppleFactory implements Factory {
	public Fruit getInstance(){
		return new Apple();
	}
}
class BananaFactory implements Factory {
	public Fruit getInstance(){
		return new Banana();
	}
}
class CherryFactory implements Factory{
	public Fruit getInstance(){
		return new Cherry();
	}
}
String [] [] a =new String[][]{{},{},{},{},{}};
public class FactoryDemo {
	public static void main(String[] args) {
//		Factory factory=new AppleFactory();
//		Fruit fruit = factory.buyFruit();
//		fruit.eat();
		Fruit f = new CherryFactory().getInstance();
		f.eat();
	}
}
