package com.crayon.youcanpass.service;

import com.crayon.youcanpass.dto.SmsMessageDto;
import com.crayon.youcanpass.model.SmsMessage;

import java.util.List;

/**
 * @Classname SmsMessageService
 * @Description 消息通知业务层接口
 * @Date 2020/3/29 18:08
 * @Created by Crayon
 */
public interface SmsMessageService extends BaseService<SmsMessage> {
    SmsMessageDto getById(Long id);
    List<SmsMessageDto> listAll();
}
