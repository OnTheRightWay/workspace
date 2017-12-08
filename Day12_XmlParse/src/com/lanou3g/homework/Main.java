package com.lanou3g.homework;

import com.lanou3g.homework.exception.*;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
					try {
						userRegister();
					} catch (RegisterException e) {
						System.out.println(e.getMessage());
						continue;
					} catch (DocumentException e) {
						e.printStackTrace();
						break;
					} catch (IOException e) {
						e.printStackTrace();
						break;
					}
					break;
				case "2":
					try {
						user = userLogin();
					} catch (LoginException e) {
						System.out.println(e.getMessage());
						continue;
					} catch (DocumentException e) {
						e.printStackTrace();
						break;
					}
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
	public static void userRegister() throws RegisterException, DocumentException, IOException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入你的姓名：");
		String name = scanner.next();
		System.out.println("请输入你的用户名：");
		String userName = scanner.next();
		if(XMLData.readXMLData(userName,"password")!=null)
			throw new UserNameIsExistsException();

		System.out.println("请输入你的密码：");
		String password = scanner.next();
		if(password.length() > 20){
			throw new PasswordTooLongException();
		}
		if (password.matches("[0-9]+")||password.length() < 3||password.matches("[a-zA-Z]+")){
			throw new PasswordUnsafeException();
		}
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
	}
	public static UserInter userLogin() throws LoginException, DocumentException {
		System.out.println("请输入用户名和密码");
		System.out.print("User:");
		String userName = new Scanner(System.in).nextLine();
		if(userName.length() > 20){
			throw new UserNameTooLongException();
		}
		if(userName.length() < 6){
			throw new UserNameTooShortException();
		}
		System.out.print("password:");
		String passWord = new Scanner(System.in).nextLine();

		return UserOperate.login(userName, passWord);
	}



}
