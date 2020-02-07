package com.crayon.youcanpass.common.exception;

import com.crayon.youcanpass.common.api.CommonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局统一拦截器
 * Created by crayon on 2020/02/05
 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionInterceptor {
    //处理参数校验异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidExceptionHandler(HttpServletRequest request,
                                                               MethodArgumentNotValidException e){
        return CommonResult.validateFailed(e.getBindingResult().getFieldError().getDefaultMessage());
    }

    //处理业务层异常
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest request,
                                                ServiceException serviceException){
        return CommonResult.error(serviceException.getCode(), serviceException.getMessage());
    }

    //处理其他异常
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest request, Exception e){
        return CommonResult.failed(e.getMessage());
    }


}
