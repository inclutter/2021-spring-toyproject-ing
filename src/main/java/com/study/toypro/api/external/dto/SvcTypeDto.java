package com.study.toypro.api.external.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias("svcTypeDto")
@Data
public class SvcTypeDto {
    public String svcType; // 서비스 타입

    public String apiResJson; // 외부 API 응답전문
}
