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
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest request, Exception e){
        CommonResult result;
        if(e instanceof MethodArgumentNotValidException){
            result = CommonResult.validateFailed(((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage());
        }else{
            result = CommonResult.failed(e.getMessage());
        }
        return result;
    }
}
