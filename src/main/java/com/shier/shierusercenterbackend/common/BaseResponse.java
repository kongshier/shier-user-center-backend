package com.shier.shierusercenterbackend.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shier
 * CreateTime 2023/5/9 15:56
 * 基本返回值类型
 */
@Data
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -3541610571427268456L;

    private int code;

    private T data;

    private String message;

    private String description;


    public BaseResponse(int code, T data, String message, String description) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.description = description;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "", "");
    }

    public BaseResponse(int code, T data, String message) {
        this(code, data, message, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage(),errorCode.getDescription());
    }
}
