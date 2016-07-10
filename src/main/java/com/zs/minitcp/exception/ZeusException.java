package com.zs.minitcp.exception;

import com.zs.minitcp.entity.response.BaseResponse;

/**
 * Created by eric on 16/5/20.
 */
public class ZeusException extends RuntimeException {


    public static ZeusException BlogClawerWxArticleError = new ZeusException("错误的文章地址", 100001);
    public static ZeusException ArgsError = new ZeusException("消息格式错误", 100002);
    public static ZeusException InerError = new ZeusException("系统内部错误",100003);
    int errorCode;
    String errorMessage;
    BaseResponse respMessage;

    public ZeusException(String message, int errorCode) {
        super(message);
        this.errorMessage = message;
        this.errorCode = errorCode;
        this.respMessage = new BaseResponse<>(errorCode, message, null);
    }

    public BaseResponse respMessage() {
        return respMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
