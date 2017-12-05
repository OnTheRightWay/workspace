package test;
//每个类四个属性
//快递员 一个不带参数不带返回值的方法
//一个不带参数带返回值的方法
//一个带参数不带返回值的方法
//一个带参数带返回值的方法
public class Courier {
	String name;
	int height;
	String sex;
	int number;
	public void work(){
		System.out.println("工作");
	}
	public int getMoney(){
		return 120;
	}
	public void work(int a){
		System.out.println("工作 "+a+" 小时");
	}
	public int workHard(int a){
		return a;
	}
}
