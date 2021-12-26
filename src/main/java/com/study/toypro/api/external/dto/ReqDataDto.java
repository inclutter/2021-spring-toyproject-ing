package com.study.toypro.api.external.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * 서비스 타입 요청 데이타 Dto
 */
@Data
@Alias("reqDataDto")
@NoArgsConstructor
public class ReqDataDto {
    private String svcType; // 서비스 타입
    private List<ReqPrprtysDataDto> scvevtPrprtys = new ArrayList<>(); // 요청 프로퍼티 데이타 리스트
}
