package com.study.toypro.api.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;


@Alias("userRoleDto")
@NoArgsConstructor
public class UserRoleDto {
    public String userId; // 유저 아이디

    public String userRole; // 유저 권한

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
