package homework;

public class Child extends Person {
	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	public void goToSchool(){
		System.out.println("����("+getName()+")��ȥ"+school+"��ѧ");
	}
}
