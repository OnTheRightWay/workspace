package mod;
//µ¥ÀýÄ£Ê½
class Singleton{
	private static Singleton instance;
	private Singleton(){}
	public synchronized Singleton getInstance(){
		if(instance==null){
			instance=new Singleton();
		}
		return instance;
	}
}

public class SingletonDemo {
	public static void main(String[] args) {
		
	}
}
