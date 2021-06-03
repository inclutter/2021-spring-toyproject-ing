package com.study.toypro.api.user.service.impl;

import com.study.toypro.api.user.dto.UserRoleDto;
import com.study.toypro.api.user.mapper.UserRoleMapper;
import com.study.toypro.api.user.service.UserRoleService;
import com.study.toypro.core.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleImpl extends BaseService implements UserRoleService {
    @Autowired
    UserRoleMapper userRoleMapper;

    /**
     * insertUserRole 구현체
     * @param param
     */
    @Override
    public void insertUserRole(UserRoleDto userRoleDto) {
        userRoleMapper.insertUserRole(userRoleDto);
    }
}
