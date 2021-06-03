package com.study.toypro.api.user.mapper;

import com.study.toypro.api.user.dto.UserRoleDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserRoleMapperTest {
    @Autowired
    UserRoleMapper userRoleMapper;

    @Test
//    @Transactional
    void insertUserRole() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId("user3");
        userRoleDto.setUserRole("ROLE_USER");

        userRoleMapper.insertUserRole(userRoleDto);
    }
}