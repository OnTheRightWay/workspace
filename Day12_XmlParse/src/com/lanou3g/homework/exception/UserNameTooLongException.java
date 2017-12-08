package com.lanou3g.homework.exception;

public class UserNameTooLongException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名过长";
    }
}
