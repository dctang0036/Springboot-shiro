package com.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "userId", type = IdType.AUTO)
    private Integer userId;

    /**
     * 登录账号
     */
    private String userName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 删除状态(0-正常,1-已删除)
     */
    private Boolean state;

    private Date createTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就不容易被破解，可以采用多种方式定义加盐
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName + this.salt;
    }


    @Override
    public String toString() {
        return "SysUser{" +
            "userId=" + userId +
            ", userName=" + userName +
            ", realName=" + realName +
            ", passWord=" + passWord +
            ", salt=" + salt +
            ", state=" + state +
            ", createTime=" + createTime +
        "}";
    }
}
