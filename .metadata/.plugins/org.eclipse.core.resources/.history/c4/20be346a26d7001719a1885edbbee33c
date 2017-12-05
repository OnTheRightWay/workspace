package com.lanou3g.homework;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("请输入用户名和密码");
		System.out.print("User:");
		@SuppressWarnings("resource")
		String userName = new Scanner(System.in).nextLine();
		System.out.print("password:");
		@SuppressWarnings("resource")
		String passWord = new Scanner(System.in).nextLine();
		UserInter user = Login.login(userName, passWord);
		
		if(user!=null){
			System.out.println("姓名："+getNameByUserName(userName)+
					" 职业："+getJobByUserName(userName)+
					"\n当前时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date()));
			boolean temp = true;
			while(temp){
				System.out.println("是否开始工作：1，是 2，否 3，终止");
				@SuppressWarnings("resource")
				int i = new Scanner(System.in).nextInt();
				switch(i){
				case 1:
					user.onLine();
					break;
				case 2:
					user.offLine();
					break;
				case 3:
					temp = false;
					break;
				default:
					break;
				}
			}
		}
		
	}
	public static String getJobByUserName(String userName){
		String temp=null;
		for(int i = 0; i<UserData.getUserData().length;i++){
			if(UserData.getUserData()[i][1].equals(userName))
				temp = UserData.getUserData()[i][3];
		}
		return temp;
	}
	public static String getNameByUserName(String userName){
		String temp=null;
		for(int i = 0; i<UserData.getUserData().length;i++){
			if(UserData.getUserData()[i][1].equals(userName))
				temp = UserData.getUserData()[i][0];
		}
		return temp;
	}
	

}
