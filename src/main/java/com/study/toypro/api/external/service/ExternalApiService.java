package com.study.toypro.api.external.service;

import com.study.toypro.api.external.dto.SvcTypeDto;

public interface ExternalApiService {
    SvcTypeDto selectExternalApiResponse(SvcTypeDto svcTypeDto);
}
