package LeiDemo;

public class Car {
	private String chePai;
	private String color;
	private int height;
	public void setChepai(String chePai){
		this.chePai=chePai;
	}
	public String getChePai(){
		return chePai;
	}
	public void setColor(String color){
		this.color=color;
	}
	public String getColor(){
		return color;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public int getHeight(){
		return height;
	}
	public void run(){
		System.out.println("车在跑");
	}
	public void carGoto(String place){
		System.out.println("车要去"+place);
	}
	public int runTime(){
		return 8;
	}
	public int time(int time){
		return 60-time;
	}
	
}
