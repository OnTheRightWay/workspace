package pets;

public class Dog extends Pets{
	private String variety;

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}
	@Override
	public void show(){
		System.out.println("我的名字叫"+getName()+
				",健康值是"+getHealth()+
				",和主人的亲密度是"+getIntimacy()+
				",种类是"+getVariety()+"。"
				);
	}
}
