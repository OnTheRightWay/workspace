package com.nys.service.domain;

import java.util.List;

public class ServiceWarp {
    private int code;
    private String message;
    private List<Service> services;

    public ServiceWarp(int code, String message, List<Service> services) {
        this.code = code;
        this.message = message;
        this.services = services;
    }

    public ServiceWarp() {
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

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
