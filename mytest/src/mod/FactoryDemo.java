package mod;
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
public  class FactoryDemo {
	public static void main(String[] args) {
//		Factory factory=new AppleFactory();
//		Fruit fruit = factory.buyFruit();
//		fruit.eat();
		Fruit f = new CherryFactory().getInstance();
		f.eat();
	}
}
