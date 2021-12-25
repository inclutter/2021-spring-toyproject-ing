package com.study.toypro.core.utilities;

import com.study.toypro.core.base.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponseUtility {
    public static <T> ResponseEntity<Object> success(T data) {
        final ApiResult<T> body = new ApiResult<T>("0200","0200",data);
        return new ResponseEntity<Object>(body, HttpStatus.OK);
    }
}
