package com.lanou3g.homework;

public class SetJob {
	public static UserInter setJob(String job){
		if("Worker".equals(job)){
			return new Worker();
		}else if("Doctor".equals(job)){
			return new Doctor();
		}else if("Cooker".equals(job)){
			return new Cooker();
		}else if("Boss".equals(job)){
			return new Boss();
		}else{ 
			System.out.println("��ҵ����");
			return null;
		} 
	}	
}
