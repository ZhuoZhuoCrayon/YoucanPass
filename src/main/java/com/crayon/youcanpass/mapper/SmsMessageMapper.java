package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.SmsMessage;
import com.crayon.youcanpass.model.SmsMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsMessageMapper {
    int countByExample(SmsMessageExample example);

    int deleteByExample(SmsMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsMessage record);

    int insertSelective(SmsMessage record);

    List<SmsMessage> selectByExampleWithBLOBs(SmsMessageExample example);

    List<SmsMessage> selectByExample(SmsMessageExample example);

    SmsMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByExample(@Param("record") SmsMessage record, @Param("example") SmsMessageExample example);

    int updateByPrimaryKeySelective(SmsMessage record);

    int updateByPrimaryKeyWithBLOBs(SmsMessage record);

    int updateByPrimaryKey(SmsMessage record);
}