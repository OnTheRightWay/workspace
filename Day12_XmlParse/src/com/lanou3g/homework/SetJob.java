package com.lanou3g.homework;

import org.dom4j.DocumentException;

public class SetJob {
	public static UserInter setJob(String userName) throws DocumentException {
		String job = XMLData.readXMLData(userName,"job");
		String name = XMLData.readXMLData(userName,"name");
		String password = XMLData.readXMLData(userName,"password");
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
