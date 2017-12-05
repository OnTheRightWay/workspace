package com.lanou3g.extend;

public class Main {

	public static void main(String[] args) {
//		BigCar big = new BigCar();
//		big.setColor("黑色");
//		big.showThis();
//		System.out.println(big.getColor());
//		MyThis myThis = new MyThis();
//		myThis.name = "张三";
//		MyThis m = new MyThis();
//		m.name = "李四";
//		
//		myThis.myName();//方法里的this指的就是myThis
//		m.myName();//方法里的this指的就是m
		
		RunCar runCar = new RunCar();
		runCar.speed();
		BigCar two = new BigCar();
		two.speed();
		
		/*
		 * 这两个speed方法，都是从Car类继承来的
		 * 但是每个方法输出的内容有不同
		 * 是因为我们在子类中给他修改了，扩展了
		 * 这就是重写
		 * 重写就是为了给每个子类添加独有的行为
		 * 重写就是复写，复写就是重写
		 * 叫法不同
		 * 
		 * 面试题中容易出现：
		 * 		请写出，复写，重载的含义
		 */
		
	}

}
