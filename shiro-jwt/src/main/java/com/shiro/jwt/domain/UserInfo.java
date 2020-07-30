package com.shiro.jwt.domain;

public class UserInfo {
    private String userName;
    private String passWord;
    private String roles;
    private String permission;

    public UserInfo(String userName, String passWord, String roles, String permission) {
        this.userName = userName;
        this.passWord = passWord;
        this.roles = roles;
        this.permission = permission;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
