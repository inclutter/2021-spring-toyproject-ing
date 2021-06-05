package com.study.toypro.api.external.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * 서비스 타입 요청 Dto
 */
@Data
@Alias("reqDto")
@NoArgsConstructor
public class ReqDto {
    private String prprtyId; // 프로퍼티 아이디

    private String roomNo; // 방 번호

    private List<ReqDataDto> reqData = new ArrayList<>(); // reqDataDto 리스트
}
