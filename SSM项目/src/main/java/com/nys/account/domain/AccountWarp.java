package com.nys.account.domain;

public class AccountWarp {
    private int code;
    private String message;
    private Account account;

    public AccountWarp() {
    }

    @Override
    public String toString() {
        return "AccountWarp{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", account=" + account +
                '}';
    }

    public AccountWarp(int code, String message, Account account) {
        this.code = code;
        this.message = message;
        this.account = account;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
