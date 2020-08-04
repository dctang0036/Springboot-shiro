package com.jwt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 登录账号
     */
    @NotBlank(message = "登陆账号不能为空！")
    private String userName;

    /**
     * 真实姓名
     */
    @NotNull(message = "真实姓名不能为null")
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
    private String delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", userName=" + userName +
            ", realName=" + realName +
            ", passWord=" + passWord +
            ", salt=" + salt +
            ", delFlag=" + delFlag +
        "}";
    }
}
