package com.wang.WMSys.com.wang.WMSys.Pojo.Entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    private Integer pkId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 账号是否过期
     */
    private Integer isAccountNonExpired;

    /**
     * 账号是否锁定
     */
    private Integer isAccountNonLocked;

    /**
     * 密码是否过期
     */
    private Integer isCredentialsNonExpired;

    /**
     * 账号是否可用
     */
    private Integer isEnabled;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getIsAccountNonExpired() == null ? other.getIsAccountNonExpired() == null : this.getIsAccountNonExpired().equals(other.getIsAccountNonExpired()))
            && (this.getIsAccountNonLocked() == null ? other.getIsAccountNonLocked() == null : this.getIsAccountNonLocked().equals(other.getIsAccountNonLocked()))
            && (this.getIsCredentialsNonExpired() == null ? other.getIsCredentialsNonExpired() == null : this.getIsCredentialsNonExpired().equals(other.getIsCredentialsNonExpired()))
            && (this.getIsEnabled() == null ? other.getIsEnabled() == null : this.getIsEnabled().equals(other.getIsEnabled()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getIsAccountNonExpired() == null) ? 0 : getIsAccountNonExpired().hashCode());
        result = prime * result + ((getIsAccountNonLocked() == null) ? 0 : getIsAccountNonLocked().hashCode());
        result = prime * result + ((getIsCredentialsNonExpired() == null) ? 0 : getIsCredentialsNonExpired().hashCode());
        result = prime * result + ((getIsEnabled() == null) ? 0 : getIsEnabled().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", isAccountNonExpired=").append(isAccountNonExpired);
        sb.append(", isAccountNonLocked=").append(isAccountNonLocked);
        sb.append(", isCredentialsNonExpired=").append(isCredentialsNonExpired);
        sb.append(", isEnabled=").append(isEnabled);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}