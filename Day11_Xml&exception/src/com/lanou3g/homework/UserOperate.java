package com.lanou3g.homework;

import com.lanou3g.homework.exception.*;

public class UserOperate {
    public static UserInter login(String userName,String passWord) throws LoginException{
        for(int i = 0; i< UserData.getUserData().size(); i++){
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
                    throw new PasswordErrorException();
                }
            }
        }
        throw new UserNameNotExistsException();
    }
    public static void register(Person person) throws RegisterException{

        UserData.getUserData().add(person);
    }
}
