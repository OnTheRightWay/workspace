package LeiDemo;

public class Student {
	private String name;
	private int age;
	private String school;
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setSchool(String school){
		this.school=school;
	}
	public String getSchool(){
		return school;
	}
	public void study(){
		System.out.println("好好学习");
	}
	public void sleep(int time){
		System.out.println("先睡"+time+"分钟");
	}
	public String play(){
		return "玩电脑";
	}
	public String playWith(Student s){
		return s.getName();
	}
	
}
