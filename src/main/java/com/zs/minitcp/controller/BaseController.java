package com.zs.minitcp.controller;

import com.zs.minitcp.exception.ZeusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {
    static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exp(Exception ex) {
        if (ex instanceof HttpMessageNotReadableException) {
            logger.error(ex.getMessage(), ex);
            return ZeusException.ArgsError.respMessage();
        }
        if (ex instanceof ZeusException) {
            ZeusException zeusException = (ZeusException) ex;
            return zeusException.respMessage();
        } else {
            logger.error(ex.getMessage(), ex);
            return ZeusException.InerError.respMessage();
        }
    }

    public void checkParams(BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            throw new ZeusException(bindingResult.getFieldError().getDefaultMessage(), ZeusException.ArgsError.getErrorCode());
        }
    }
}
