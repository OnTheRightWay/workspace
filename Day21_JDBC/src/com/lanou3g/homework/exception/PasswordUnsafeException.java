package com.lanou3g.homework.exception;

public class PasswordUnsafeException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不安全";
    }
}
