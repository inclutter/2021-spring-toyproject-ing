package com.study.toypro.api.user.mapper;

import com.study.toypro.api.user.dto.UserRoleDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    void insertUserRole(UserRoleDto userRoleDto);
}
