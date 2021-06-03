package com.study.toypro.api.user.mapper;

import com.study.toypro.api.user.dto.UserRoleDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRoleMapperTest {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Test
    public void insertUserRole() {

        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId("user5");
        userRoleDto.setUserRole("ROLE_USER");

        userRoleMapper.insertUserRole(userRoleDto);

    }
}