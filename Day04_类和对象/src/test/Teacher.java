package test;
//每个类四个属性
//一个不带参数不带返回值的方法
//一个不带参数带返回值的方法
//一个带参数不带返回值的方法
//一个带参数带返回值的方法
public class Teacher {
	String name;
	int age=18;
	String sex;
	int salary;
	public void teach(){
		System.out.println("在教书");
	}
	public void say(String say){
		System.out.println(say);
	}
	public String goHome(){
		return "走回家";
	}
	public String walkTime(int min){
		return "走了"+min+"分钟";
	}
}
