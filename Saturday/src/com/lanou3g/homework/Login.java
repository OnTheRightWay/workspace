package com.lanou3g.homework;

public class Login {
	public static UserInter login(String userName,String passWord){
		UserInter temp = null;
		for(int i = 0; i<UserData.getUserData().length;i++){
			if(userName.equals(UserData.getUserData()[i][1])){
				if(passWord.equals(UserData.getUserData()[i][2])){
					temp = SetJob.setJob(UserData.getUserData()[i][3]);
				}else{ 
					System.out.println("�������");
				}
			}
		}
		if(temp==null){
			System.out.println("��¼ʧ��");
		}else System.out.println("��¼�ɹ�");
		return temp;
	}
}
