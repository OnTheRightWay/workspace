package test;
//每个类四个属性
//一个不带参数不带返回值的方法
//一个不带参数带返回值的方法
//一个带参数不带返回值的方法
//一个带参数带返回值的方法
public class Student {
	String name;
	int age=18;
	String sex;
	int number;
	public void study(){
		System.out.println("在学习");
	}
	public int getAge(){
		return age;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public int add(int a,int b){
		return a+b;
	}
}
