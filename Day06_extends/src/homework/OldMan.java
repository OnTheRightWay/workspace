package homework;

public class OldMan extends Person {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void happy(){
		System.out.println("老人("+getName()+")：这"+age+"年，我都很开心");
	}
}
