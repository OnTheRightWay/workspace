package pets;

public class Penguin extends Pets{
	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public void show(){
		System.out.println("我的名字叫"+getName()+
				",健康值是"+getHealth()+
				",和主人的亲密度是"+getIntimacy()+
				",种类是"+getSex()+"。"
				);
	}
}
