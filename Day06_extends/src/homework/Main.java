package homework;

public class Main {
	public static void main(String[] args) {
		Man man=new Man();
		man.setName("张三");
		man.setTime(9);
		man.work();
		Child child=new Child();
		child.setName("李四");
		child.setSchool("希望小学");
		child.goToSchool();
		OldMan oldMan =new OldMan();
		oldMan.setName("王五");
		oldMan.setAge(98);
		oldMan.happy();
	}
}
