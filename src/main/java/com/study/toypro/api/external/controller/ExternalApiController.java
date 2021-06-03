package com.study.toypro.api.external.controller;

import com.study.toypro.api.external.dto.SvcTypeDto;
import com.study.toypro.api.external.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalApiController {
    @Autowired
    ExternalApiService externalApiService;

    @PostMapping("/v1/services")
    public String selectExternalApiResponse() {
        SvcTypeDto svcTypeDto = new SvcTypeDto();
        svcTypeDto.setSvcType("st00001603");
        SvcTypeDto svcTypeDto1 = externalApiService.selectExternalApiResponse(svcTypeDto);
        return svcTypeDto1.getApiResJson();
    }
}
