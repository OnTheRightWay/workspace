package com.lanou3g.homework.exception;

public class UserNameNotExistsException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名不存在";
    }
}
