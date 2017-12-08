package com.lanou3g.homework;

public class SetJob {
	public static UserInter setJob(Person person){
		if("Worker".equals(person.getJob())){
			return new Worker(person.getName(),person.getUserName(),person.getPassword(),person.getJob());
		}else if("Doctor".equals(person.getJob())){
			return new Doctor(person.getName(),person.getUserName(),person.getPassword(),person.getJob());
		}else if("Cooker".equals(person.getJob())){
			return new Cooker(person.getName(),person.getUserName(),person.getPassword(),person.getJob());
		}else if("Boss".equals(person.getJob())){
			return new Boss(person.getName(),person.getUserName(),person.getPassword(),person.getJob());
		}else{ 
			System.out.println("无业游民？");
			return null;
		} 
	}	
}
