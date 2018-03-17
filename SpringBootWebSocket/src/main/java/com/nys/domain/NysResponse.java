package com.nys.domain;

/**
 * 服务器向浏览器发消息时，通过此类作为载体传输
 */
public class NysResponse {
    private String responseMessage;

    public NysResponse(String responseMessage){
        this.responseMessage=responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
