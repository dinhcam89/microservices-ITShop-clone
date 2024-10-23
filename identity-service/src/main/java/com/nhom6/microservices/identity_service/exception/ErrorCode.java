package com.nhom6.microservices.identity_service.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION(400, "Uncategorized Exception"),
    INVALID_KEY_EXCEPTION(1000, "Uncategorized Exception"),
    USER_EXISTED(1001, "User existed"),
    USERNAME_INVALID(1002, "Username must be at least 3 characters"),
    INVALID_PASSWORD(1003, "Password must be at least 8 characters"),
    USER_NOT_FOUND(1004, "User not found"),
    UNAUTHENTICATED(1005, "Unauthenticated"),
    ;

    int Code;
    String Message;
    ErrorCode(int code, String message) {
        this.Code = code;
        this.Message = message;
    }

}
