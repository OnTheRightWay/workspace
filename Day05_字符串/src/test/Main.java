package test;

public class Main {
	public static void main(String[] args) {
		Student s = new Student();
		Student stu = new Student();
		//通过getName方法，
		//拿到s对象的name属性
		String name = s.getName();
		
		//当执行了setName方法是，就将这个字符串
		//传给了参数列表中的参数n
		name = stu.getName();
		System.out.println("改之前："+name);
		
		stu.setName("她师妹");
		name = stu.getName();
		System.out.println("改之后："+name);
		
		//得到的sad方法执行的结果
		//吧这个结果赋值给了result这个变量
		String result=s.sad();
		System.out.println(result);
	}
}
