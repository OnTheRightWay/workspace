package family;

class Father{
	private Mother wife;
	private Child child;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Mother getWife() {
		return wife;
	}
	public void setWife(Mother wife) {
		this.wife = wife;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
}
class Mother{
	private Father husband;
	private Child child;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Father getHusband() {
		return husband;
	}
	public void setHusband(Father husband) {
		this.husband = husband;
	}
	public Child getChild() {
		return child;
	}
	public void setChild(Child child) {
		this.child = child;
	}
}
class Child{
	private Father papa;
	private Mother mama;
	private String name;
	public Father getPapa() {
		return papa;
	}
	public void setPapa(Father papa) {
		this.papa = papa;
	}
	public Mother getMama() {
		return mama;
	}
	public void setMama(Mother mama) {
		this.mama = mama;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


public class Family {

	public static void main(String[] args) {
		Father f = new Father();
		f.setName("张三");
		Mother m = new Mother();
		m.setName("李四");
		Child c = new Child();
		c.setName("王五");
		
		f.setWife(m);
		f.setChild(c);
		m.setHusband(f);
		m.setChild(c);
		c.setMama(m);
		c.setPapa(f);
		System.out.println("老婆叫:"+f.getWife().getName());
		System.out.println("孩子叫:"+f.getChild().getName());
		System.out.println();
		System.out.println("老公叫:"+m.getHusband().getName());
		System.out.println("孩子叫:"+m.getChild().getName());
		System.out.println();
		System.out.println("妈妈叫:"+c.getMama().getName());
		System.out.println("爸爸叫:"+c.getPapa().getName());
	}

}
