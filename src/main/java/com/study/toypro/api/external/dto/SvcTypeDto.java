package com.study.toypro.api.external.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("svcTypeDto")
@Data
public class SvcTypeDto {
    public String svcType; // 서비스 타입

    public String extApiResponse; // 외부 API 응답전문
}
