package com.lanou3g.homework;

public class Mother {
	private String name;
	private Father husband;
	private Child child;
	
	public void setHusband(Father husband){
		this.husband=husband;
	}
	public void setChild(Child child){
		this.child=child;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void showFamily(){
		System.out.println(name+"���ɷ���"+husband.getName()
						+",���ĺ�����"+child.getName());
	}
}
