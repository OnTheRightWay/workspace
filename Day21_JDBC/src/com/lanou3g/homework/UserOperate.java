package com.lanou3g.homework;

import com.lanou3g.homework.exception.PasswordErrorException;
import com.lanou3g.homework.util.*;
import com.lanou3g.homework.bean.Person;
import com.lanou3g.homework.bean.UserInter;
import com.lanou3g.homework.exception.LoginException;
import com.lanou3g.homework.exception.RegisterException;


public class UserOperate {
    public static UserInter login(String userName, String passWord) throws LoginException {
        String password = MysqlUtil.getdata(userName,"password");
        if (passWord.equals(password)){
            return SetJob.setJob(userName);
        }
        throw new PasswordErrorException();
    }
    public static void register(Person person) throws RegisterException {
        MysqlUtil.insert(person.getUserName(),person.getPassword(),person.getName(),person.getJob());
    }
}
