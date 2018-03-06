package com.nys.crm.staff.service.exception;

public class PasswordErrorException extends UpdatePswException {
    @Override
    public String getMessage() {
        return "密码错误";
    }
}
