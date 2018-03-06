package com.nys.admin.service.exception;

public class LoginException extends Exception {
    @Override
    public String getMessage() {
        return "用户名或密码错误，请重试";
    }
}
