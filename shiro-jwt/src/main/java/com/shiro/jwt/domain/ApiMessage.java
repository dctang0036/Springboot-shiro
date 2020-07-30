package com.shiro.jwt.domain;

public class ApiMessage<T> {
    private boolean status;
    private String code;
    private String length;
    private T msg;

    public ApiMessage(boolean status, String code, String length, T msg) {
        this.status = status;
        this.code = code;
        this.length = length;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public T getMsg() {
        return msg;
    }

    public void setMsg(T msg) {
        this.msg = msg;
    }
}
