package com.lanou3g.homework;

public class UserOperate {
    public static UserInter login(String userName,String passWord){
        for(int i = 0; i<UserData.getUserData().size();i++){
            if(userName.equals(UserData.getUserData().get(i).getUserName())){
                if(passWord.equals(UserData.getUserData().get(i).getPassword())){
                    Person person = null;
                    for (int j = 0; j < UserData.getUserData().size(); j++) {
                        if(userName.equals(UserData.getUserData().get(j).getUserName())){
                            person = UserData.getUserData().get(j);
                        }
                    }
                    return SetJob.setJob(person);
                }else{
                    System.out.println("密码错误");
                    return null;
                }
            }
        }
        System.out.println("该用户不存在");
        return null;
    }
    public static void register(Person person){
        UserData.getUserData().add(person);
    }
}
