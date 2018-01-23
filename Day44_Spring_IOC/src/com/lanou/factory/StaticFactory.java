package com.lanou.factory;

import com.lanou.createobj.User;

public class StaticFactory {

    //静态工厂
    public static User getInstance(){
        return new User();
    }
}
