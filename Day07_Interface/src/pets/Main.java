package pets;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("欢迎来到宠物商店\n给你的"
				+ "宠物起个名字吧！");
		Pets.setName(new Scanner(System.in).next());
		System.out.println("请选择要领养的宠物类型（1、狗狗 2、企鹅）");
		String temp = new Scanner(System.in).next();
		if("1".equals(temp)){
			Dog dog = new Dog();
			System.out.println("请选择狗狗的品种（1、聪明的拉布拉多犬  2、酷酷的雪纳瑞）");
			String s= new Scanner(System.in).next();
			if("1".equals(s)){
				dog.setVariety("聪明的拉布拉多犬");
			}else if("2".equals(s)){
				dog.setVariety("酷酷的雪纳瑞");
			}else {
				System.out.println("请输入1或2");
			}
			System.out.println("宠物的自白");
			dog.show();
		}else if("2".equals(temp)){
			Penguin penguin = new Penguin();
			System.out.println("请选择企鹅的品种（1、Q仔  2、Q妹）");
			String s= new Scanner(System.in).next();
			if("1".equals(s)){
				penguin.setSex("Q仔");
			}else if("2".equals(s)){
				penguin.setSex("Q妹");
			}else {
				System.out.println("请输入1或2");
			}
			System.out.println("宠物的自白");
			penguin.show();
		}else System.out.println("请输入1或2");
		
		
	}

}
