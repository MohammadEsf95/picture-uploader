package com.example.demo.presentation.responseentity.response;

import com.example.demo.presentation.responseentity.ResponseEntityMessageAndCode;

public class ServiceUnavailableResponseEntity<T> extends BaseResponseEntity<T> {
    public ServiceUnavailableResponseEntity(T content) {
        super(
                ResponseEntityMessageAndCode.SERVICE_UNAVAILABLE.getTitle(),
                ResponseEntityMessageAndCode.SERVICE_UNAVAILABLE.getCode(),
                content
        );
    }
}
