package com.lanou3g.homework.exception;

public class PasswordErrorException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名与密码不匹配";
    }
}
