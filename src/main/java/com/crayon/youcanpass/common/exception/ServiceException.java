package com.crayon.youcanpass.common.exception;

import com.crayon.youcanpass.common.api.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname ServiceException
 * @Description 业务层异常类
 * @Date 2020/2/7 13:46
 * @Created by Crayon
 */
@Setter
@Getter
public class ServiceException extends RuntimeException {
    private Long code;
    private String message;

    public ServiceException(Long code, String message){
        super();
        this.code = code;
        this.message = message;
    }

    public static ServiceException failed(String message){
        return new ServiceException(ResultCode.FAILED.getCode(), message);
    }

    public static ServiceException failed(){
        return new ServiceException(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage());
    }

    public static ServiceException forbidden(String message){
        return new ServiceException(ResultCode.FORBIDDEN.getCode(), message);
    }

    public static ServiceException forbidden(){
        return new ServiceException(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage());
    }
}
