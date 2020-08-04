package com.jwt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author dctang
 * @since 2020-07-30
 */
@TableName("sys_permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 菜单标题
     */
    private String name;

    /**
     * 路径
     */
    private String url;

    /**
     * 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    private Integer menuType;

    /**
     * 菜单权限编码
     */
    private String perms;

    /**
     * 菜单排序
     */
    private Integer sortNo;

    /**
     * 删除状态 0正常 1已删除
     */
    private Integer delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getMenuType() {
        return menuType;
    }

    public void setMenuType(Integer menuType) {
        this.menuType = menuType;
    }
    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "Permission{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", name=" + name +
            ", url=" + url +
            ", menuType=" + menuType +
            ", perms=" + perms +
            ", sortNo=" + sortNo +
            ", delFlag=" + delFlag +
        "}";
    }
}
