package test;

public class Main {
	public static void main(String[] args){
		Courier courier=new Courier();
		Saleman saleman=new Saleman();
		Student student=new Student();
		Teacher teacher=new Teacher();
		courier.work();
		courier.work(5);
		System.out.println("努力了 "+courier.workHard(3)+"小时");
		System.out.println("赚到了 "+courier.getMoney());
		System.out.println();
		
		saleman.sleep();
		System.out.println("应找 "+saleman.pay(saleman.getMoney())+"元");
		saleman.say("谢谢光临");
		System.out.println();
		
		System.out.println("年龄："+student.getAge());
		student.setSex("男");
		System.out.println("性别为："+student.sex);
		System.out.println("加法运算值为："+student.add(10, -5));
		System.out.println();
		
		teacher.teach();
		teacher.say("上课");
		System.out.println(teacher.goHome());
		System.out.println(teacher.walkTime(15));
	}
}
