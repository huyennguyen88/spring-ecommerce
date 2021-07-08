package com.example.springecommerce.constants;

public enum ErrorType {
    ACCESS_DENIED("403");

    public final String code;

    ErrorType(String code) {
        this.code = code;
    }
}
