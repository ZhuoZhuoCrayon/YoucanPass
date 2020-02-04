package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.SmsOpencourseRecord;
import com.crayon.youcanpass.model.SmsOpencourseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsOpencourseRecordMapper {
    int countByExample(SmsOpencourseRecordExample example);

    int deleteByExample(SmsOpencourseRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsOpencourseRecord record);

    int insertSelective(SmsOpencourseRecord record);

    List<SmsOpencourseRecord> selectByExampleWithBLOBs(SmsOpencourseRecordExample example);

    List<SmsOpencourseRecord> selectByExample(SmsOpencourseRecordExample example);

    SmsOpencourseRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsOpencourseRecord record, @Param("example") SmsOpencourseRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") SmsOpencourseRecord record, @Param("example") SmsOpencourseRecordExample example);

    int updateByExample(@Param("record") SmsOpencourseRecord record, @Param("example") SmsOpencourseRecordExample example);

    int updateByPrimaryKeySelective(SmsOpencourseRecord record);

    int updateByPrimaryKeyWithBLOBs(SmsOpencourseRecord record);

    int updateByPrimaryKey(SmsOpencourseRecord record);
}