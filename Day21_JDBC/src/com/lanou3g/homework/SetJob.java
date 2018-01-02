package com.lanou3g.homework;

import com.lanou3g.homework.bean.*;
import com.lanou3g.homework.util.*;
public class SetJob {
	public static UserInter setJob(String userName){
		String job = MysqlUtil.getdata(userName,"job");
		String name =  MysqlUtil.getdata(userName,"name");
		String password =  MysqlUtil.getdata(userName,"password");
		if("Worker".equals(job)){
			return new Worker(name,userName,password,job);
		}else if("Doctor".equals(job)){
			return new Doctor(name,userName,password,job);
		}else if("Cooker".equals(job)){
			return new Cooker(name,userName,password,job);
		}else if("Boss".equals(job)){
			return new Boss(name,userName,password,job);
		}else{ 
			System.out.println("无业游民？");
			return null;
		} 
	}	
}
