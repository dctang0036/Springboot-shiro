package com.shiro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "roleid", type = IdType.AUTO)
    private Integer roleid;

    private String available;

    /**
     * 描述
     */
    private String description;

    /**
     * 角色名称
     */
    private String role;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SysRole{" +
            "roleid=" + roleid +
            ", available=" + available +
            ", description=" + description +
            ", role=" + role +
        "}";
    }
}
