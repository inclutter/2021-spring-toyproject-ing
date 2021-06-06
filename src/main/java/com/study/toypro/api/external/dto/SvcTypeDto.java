package com.study.toypro.api.external.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * 전달받은 svcType Mybatis로 전달하는 Dto 객체
 */
@Data
@Alias("svcTypeDto")
@NoArgsConstructor
public class SvcTypeDto {
    public String svcType; // 서비스 타입

    public String apiResJson; // 외부 API 응답전문

    public String prprtyId; // 프로퍼티 아이디

    public String roomNo; // 방 번호
}
