package com.study.toypro.core.utilities;

import com.study.toypro.core.base.ApiResult;
import com.study.toypro.core.base.ResultCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtility {

    public static ResponseEntity<Object> success(DataMap data) {
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    public static <T> ResponseEntity<Object> success(T data) {
        final ApiResult<T> body = new ApiResult<T>("200", StaticMessageSourceUtility.getMessage(ResultCodes.SUCCESS_200.getMsgId()), data);
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
