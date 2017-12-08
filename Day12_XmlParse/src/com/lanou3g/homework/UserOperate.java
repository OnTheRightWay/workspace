package com.lanou3g.homework;

import com.lanou3g.homework.exception.LoginException;
import com.lanou3g.homework.exception.PasswordErrorException;
import com.lanou3g.homework.exception.RegisterException;
import com.lanou3g.homework.exception.UserNameNotExistsException;
import org.dom4j.DocumentException;

import java.io.IOException;

public class UserOperate {
    public static UserInter login(String userName,String passWord) throws LoginException, DocumentException {
        String password = XMLData.readXMLData(userName,"password");
        if (password==null){
            throw new UserNameNotExistsException();
        }
        if(passWord.equals(password)){
            return SetJob.setJob(XMLData.readXMLData(userName,"userName"));
        }
        throw new PasswordErrorException();
    }
    public static void register(Person person) throws DocumentException, IOException {

        XMLData.writeXMLData(person);
    }
}
