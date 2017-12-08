package com.lanou3g.homework.exception;

public class UserNameIsExistsException extends RegisterException {
    @Override
    public String getMessage() {
        return "账号已存在";
    }
}
