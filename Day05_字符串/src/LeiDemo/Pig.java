package LeiDemo;

public class Pig {
	private int weight;
	private String name;
	private int foot;
	public void setWeight(int weight){
		this.weight=weight;
	}
	public int getWeight(){
		return weight;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setFoot(int foot){
		this.foot=foot;
	}
	public int getFoot(){
		return foot;
	}
	public void shout(){
		System.out.println("���ڽ�");
	}
	public void eat(String food){
		System.out.println("���ڳ�"+food);
	}
	public int sleep(){
		return 5;
	}
	public String add(int weight){
		return "������"+(weight-this.weight)+"��";
	}
}
