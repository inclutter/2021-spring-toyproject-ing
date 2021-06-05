package com.study.toypro.api.external.controller;

import com.study.toypro.api.external.dto.ReqDto;
import com.study.toypro.api.external.dto.SvcTypeDto;
import com.study.toypro.api.external.service.ExternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalApiController {
    @Autowired
    ExternalApiService externalApiService;

    /**
     * reqDto를 전달받아서 해당 요청 전문에 있는 svcType으로 이미 작성된 json 요청 전문을 반환하는 컨트롤러
     * @param reqDto
     * @return
     */
    @PostMapping("/v1/services")
    public String selectExternalApiResponse(@RequestBody ReqDto reqDto) {
        System.out.println(reqDto.toString());
        SvcTypeDto svcTypeDto = new SvcTypeDto();
        svcTypeDto.setSvcType(reqDto.getReqData().get(0).getSvcType());
        SvcTypeDto svcTypeDto1 = externalApiService.selectExternalApiResponse(svcTypeDto);
        return svcTypeDto1.getApiResJson();
    }
}
