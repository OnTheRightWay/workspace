package LeiDemo;

public class Cup {
	private int size;
	private String color;
	private int weight;
	public void setSize(int size){
		this.size=size;
	}
	public int getSize(){
		return size;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
	public void setWeight(int weight){
		this.weight=weight;
	}
	public int getWeight(){
		return weight;
	}
	public void take(){
		System.out.println("杯子被带走了");
	}
	public void putIn(String s){
		System.out.println("杯子装"+s);
	}
	public double putOut(){
		return 90.5;
	}
	public double add(int i){
		return i-90.5;
	}
}
