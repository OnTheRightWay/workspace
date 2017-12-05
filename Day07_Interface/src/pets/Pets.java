package pets;

public abstract class Pets {
	private static String Name;
	private int health = 100;
	private int intimacy = 0;
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getIntimacy() {
		return intimacy;
	}
	public void setIntimacy(int intimacy) {
		this.intimacy = intimacy;
	}
	public abstract void show();
	
}
