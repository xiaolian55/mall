package com.nikki.mall.tiny.common.api;

/**
 * 用于返回对象
 */
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult(){
    }

    protected CommonResult(long code,String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     *
     * @param data 获取的数据
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return  new CommonResult<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     *
     * @param data
     * @param msg 提示信息
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data, String msg){
        return  new CommonResult<T>(ResultCode.SUCCESS.getCode(), msg, data);
    }

    /**
     *
     * @param errorCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return  new CommonResult<T>(errorCode.getCode(),errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed() {
        return failed(ResultCode.FAILED);
    }

    public static <T> CommonResult<T> validateFailed(String msg){
        return  new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(),msg, null);
    }

    public static <T> CommonResult<T> unauthorized(T data){
        return  new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> CommonResult<T> forbidden(T data){
        return  new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),ResultCode.FORBIDDEN.getMessage(), data);
    }
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
