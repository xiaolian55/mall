package com.nikki.mall.tiny.common.api;

public enum ResultCode implements IErrorCode{
    SUCCESS(200,"success"),
    FAILED(500,"failed"),
    VALIDATE_FAILED(404,"validate failed"),
    UNAUTHORIZED(403,"unauthorized"),
    FORBIDDEN(403,"don't have relate permission");

    private long code;
    private String message;

    private ResultCode(long code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
