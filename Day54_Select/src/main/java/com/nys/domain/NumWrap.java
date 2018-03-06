package com.nys.domain;

import java.util.List;

public class NumWrap {
    private int code;
    private String message;
    private List<String> list;

    public NumWrap() {
    }

    public NumWrap(int code, String message, List<String> list) {
        this.code = code;
        this.message = message;
        this.list = list;
    }

    @Override
    public String toString() {
        return "NumWrap{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", list=" + list +
                '}';
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
