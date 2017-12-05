package com.lanou3g.homework;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		UserInter user = null;
		Scanner scanner = new Scanner(System.in);
		boolean comeIn = false;
		while (!comeIn){
			System.out.println("1.注册	2.登录");
			String scan1 = scanner.nextLine();
			switch (scan1){
				case "1":
					userRegister();
					break;
				case "2":
					user = userLogin();
					comeIn = true;
					break;
				default:
					System.out.println("输入错误，请选择 1 或 2");
					break;
			}
		}
		if(user!=null){
			Person person = (Person)user;
			System.out.println("姓名："+person.getName()+
					" 职业："+person.getJob()+
					"\n当前时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date()));

			System.out.println("是否开始工作：1，是	2，否");
			String i = new Scanner(System.in).nextLine();
			switch(i){
				case "1":
					user.onLine();
					break;
				case "2":
					user.offLine();
					break;
				default:
					break;
			}

		}
		
	}
	public static boolean userRegister(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的姓名：");
		String name = scanner.next();
		System.out.println("请输入你的用户名：");
		String userName = scanner.next();
		for (int j = 0; j < UserData.getUserData().size(); j++) {
			if(userName.equals(UserData.getUserData().get(j).getUserName())){
				System.out.println("用户已存在");
				return false;
			}
		}
		System.out.println("请输入你的密码：");
		String password = scanner.next();
		System.out.println("请输入你的职业：Boss,Cooker,Doctor,Worker");
		String job = scanner.next();
		Person person;
		switch (job){
			case "Boss":
				person = new Boss(name,userName,password,job);
				break;
			case "Cooker":
				person = new Cooker(name,userName,password,job);
				break;
			case "Doctor":
				person = new Doctor(name,userName,password,job);
				break;
			case "Worker":
				person = new Worker(name,userName,password,job);
				break;
				default:
					person = null;
					System.out.println("请选择正确的职业");
					break;
		}
		if (person!=null)
			UserOperate.register(person);
		return true;
	}
	public static UserInter userLogin(){
		System.out.println("请输入用户名和密码");
		System.out.print("User:");
		String userName = new Scanner(System.in).nextLine();
		System.out.print("password:");
		String passWord = new Scanner(System.in).nextLine();
		return UserOperate.login(userName, passWord);
	}



}
