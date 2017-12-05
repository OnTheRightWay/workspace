package homework;

public class Man extends Person{
	private int time;
	public Man(){
		this.time=8;
	}
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public void work(){
		System.out.println("男人("+getName()+")：我今天要工作"+time+"小时");
	}
}
