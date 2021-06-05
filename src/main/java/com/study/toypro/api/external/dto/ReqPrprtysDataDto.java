package com.study.toypro.api.external.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * 서비스 저장소 코드, 저장소 값 Dto
 */
@Data
@Alias("reqPrprtysDataDto")
@NoArgsConstructor
public class ReqPrprtysDataDto {
    private String svcevtPrprtyCd; // 서비스 저장소 코드

    private String svcevtPrprtyVal; // 서비스 저장소 값
}
