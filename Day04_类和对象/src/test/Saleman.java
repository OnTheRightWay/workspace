package test;
//每个类四个属性
//一个不带参数不带返回值的方法
//一个不带参数带返回值的方法
//一个带参数不带返回值的方法
//一个带参数带返回值的方法
public class Saleman {
	String name;
	int weight;
	String sex;
	int number;
	public void sleep(){
		System.out.println("睡觉");
	}
	public int getMoney(){
		return 90;
	}
	public int pay(int getMoney){
		return getMoney-50;
	}
	public void say(String s){
		System.out.println("说："+s);
	}
}
