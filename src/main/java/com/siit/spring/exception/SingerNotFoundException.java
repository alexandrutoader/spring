package com.siit.spring.exception;

import org.springframework.core.NestedRuntimeException;

public class SingerNotFoundException extends NestedRuntimeException {

    public SingerNotFoundException(String message) {
        super(message);
    }
}
