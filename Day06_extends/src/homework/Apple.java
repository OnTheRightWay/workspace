package homework;

public class Apple extends Fruit{
	private int size=5;
	public void drop(){
		System.out.println(size+"斤的苹果掉下来啦");
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
