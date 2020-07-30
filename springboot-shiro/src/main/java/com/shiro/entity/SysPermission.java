package com.shiro.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 菜单权限表
 * </p>
 *
 * @author dctang
 * @since 2020-07-22
 */
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("permissionId")
    private Integer permissionId;

    /**
     * 父id
     */
    private Integer available;

    /**
     * 菜单标题
     */
    private String permissionname;

    /**
     * 路径
     */
    private Integer parentid;

    /**
     * 菜单类型(0:一级菜单; 1:子菜单:2:按钮权限)
     */
    private String parentids;

    /**
     * 菜单权限编码
     */
    private String permission;

    /**
     * 菜单排序
     */
    private String resourcetype;

    /**
     * 删除状态 0正常 1已删除
     */
    private String url;

    private Integer level;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }
    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    public String getParentids() {
        return parentids;
    }

    public void setParentids(String parentids) {
        this.parentids = parentids;
    }
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(String resourcetype) {
        this.resourcetype = resourcetype;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
            "permissionId=" + permissionId +
            ", available=" + available +
            ", permissionname=" + permissionname +
            ", parentid=" + parentid +
            ", parentids=" + parentids +
            ", permission=" + permission +
            ", resourcetype=" + resourcetype +
            ", url=" + url +
            ", level=" + level +
        "}";
    }
}
