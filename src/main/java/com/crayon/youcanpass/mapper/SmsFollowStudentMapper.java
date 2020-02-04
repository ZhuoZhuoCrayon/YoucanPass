package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.SmsFollowStudent;
import com.crayon.youcanpass.model.SmsFollowStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFollowStudentMapper {
    int countByExample(SmsFollowStudentExample example);

    int deleteByExample(SmsFollowStudentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsFollowStudent record);

    int insertSelective(SmsFollowStudent record);

    List<SmsFollowStudent> selectByExampleWithBLOBs(SmsFollowStudentExample example);

    List<SmsFollowStudent> selectByExample(SmsFollowStudentExample example);

    SmsFollowStudent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsFollowStudent record, @Param("example") SmsFollowStudentExample example);

    int updateByExampleWithBLOBs(@Param("record") SmsFollowStudent record, @Param("example") SmsFollowStudentExample example);

    int updateByExample(@Param("record") SmsFollowStudent record, @Param("example") SmsFollowStudentExample example);

    int updateByPrimaryKeySelective(SmsFollowStudent record);

    int updateByPrimaryKeyWithBLOBs(SmsFollowStudent record);

    int updateByPrimaryKey(SmsFollowStudent record);
}