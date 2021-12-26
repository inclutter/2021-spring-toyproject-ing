package com.study.toypro.api.external.service.impl;

import com.study.toypro.api.external.dto.SvcTypeDto;
import com.study.toypro.api.external.mapper.ExternalApiMapper;
import com.study.toypro.api.external.service.ExternalApiService;
import com.study.toypro.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalApiServiceImpl extends BaseService implements ExternalApiService {
    @Autowired
    ExternalApiMapper externalApiMapper;

    @Override
    public SvcTypeDto selectExternalApiResponse(SvcTypeDto svcTypeDto) {
        return externalApiMapper.selectExternalApiResponse(svcTypeDto);
    }
}
