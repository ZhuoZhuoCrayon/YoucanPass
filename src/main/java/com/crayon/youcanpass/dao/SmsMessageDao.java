package com.crayon.youcanpass.dao;

import com.crayon.youcanpass.dto.SmsMessageDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Classname SmsMessageDao
 * @Description 通知信息Dao接口
 * @Date 2020/3/29 20:14
 * @Created by Crayon
 */
public interface SmsMessageDao {
    List<SmsMessageDto> list();
    SmsMessageDto get(@Param("id") Long id);
}
