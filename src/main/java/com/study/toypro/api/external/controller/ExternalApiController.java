package com.study.toypro.api.external.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.toypro.api.external.dto.ReqDto;
import com.study.toypro.api.external.dto.SvcTypeDto;
import com.study.toypro.api.external.service.ExternalApiService;
import com.study.toypro.core.utilities.ApiResponseUtility;
import com.study.toypro.core.utilities.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//@RestController
public class ExternalApiController {
    @Autowired
    ExternalApiService externalApiService;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * reqDto를 전달받아서 해당 요청 전문에 있는 svcType으로 이미 작성된 json 요청 전문을 반환하는 컨트롤러
     * @param reqDto
     * @return
     */
    @PostMapping("/v1/services")
    public ResponseEntity<Object> selectExternalApiResponse(@RequestBody ReqDto reqDto) throws JsonProcessingException {
        SvcTypeDto svcTypeDto = new SvcTypeDto();
        DataMap result;
        svcTypeDto.setPrprtyId(reqDto.getPrprtyId());
        svcTypeDto.setRoomNo(reqDto.getRoomNo());
        svcTypeDto.setSvcType(reqDto.getReqData().get(0).getSvcType());
        SvcTypeDto externalApiResponse = externalApiService.selectExternalApiResponse(svcTypeDto);
        result = objectMapper.readValue(externalApiResponse.getApiResJson(), new TypeReference<DataMap>() {});
        return ApiResponseUtility.success(result);
    }
}
