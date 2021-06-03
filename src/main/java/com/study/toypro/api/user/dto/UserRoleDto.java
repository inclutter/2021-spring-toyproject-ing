package com.study.toypro.api.user.dto;

import lombok.*;
import org.apache.ibatis.type.Alias;


@Alias("userRoleDto")
@NoArgsConstructor
@Data
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
