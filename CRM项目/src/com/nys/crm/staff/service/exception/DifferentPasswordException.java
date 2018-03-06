package com.nys.crm.staff.service.exception;

public class DifferentPasswordException extends UpdatePswException {
    @Override
    public String getMessage() {
        return "密码不一致";
    }
}
