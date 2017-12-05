package com.lanou3g.change;

public class Main {

	public static void main(String[] args) {
		//父类的引用指向了子类的对象
		Fruit fruit = new Apple();
		
//		fruit = new Banana();
		
		//父类的引用，只能找到父类的方法
		//找不到子类独有的方法
		fruit.eat();
		if(fruit instanceof Apple){
			//如果这个引用指向的对象为Apple
			//那么我们可以进行强制类型转换
			
			//()中写的就是要强转的类型
			Apple  redApple = (Apple)fruit;
			redApple.drop();
		}
		
	}

}
