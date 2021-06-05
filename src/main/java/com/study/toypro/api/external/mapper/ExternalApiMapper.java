package com.study.toypro.api.external.mapper;

import com.study.toypro.api.external.dto.SvcTypeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExternalApiMapper {
    SvcTypeDto selectExternalApiResponse(SvcTypeDto svcTypeDto);
}
