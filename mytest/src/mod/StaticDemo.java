package mod;
class A{
	public static void print(){
		System.out.println("zhu");
	} 
}
class B extends A{
	public static void print(){
		System.out.println("gou");
	}
}
public class StaticDemo {

	public static void main(String[] args) {
//		A a1=new B();
//		A a2=new A();
		A.print();
		A.print();
		B b=new B();
		b.print();
	}

}
