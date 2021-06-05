package com.study.toypro.api.external.mapper;

import com.study.toypro.api.external.dto.SvcTypeDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExternalApiMapperTest {
    @Autowired
    ExternalApiMapper externalApiMapper;

    @Test
    public void selectExternalApiResponse() {
        SvcTypeDto svcTypeDto = new SvcTypeDto();
        svcTypeDto.setSvcType("st00001603");

        externalApiMapper.selectExternalApiResponse(svcTypeDto);
    }
}