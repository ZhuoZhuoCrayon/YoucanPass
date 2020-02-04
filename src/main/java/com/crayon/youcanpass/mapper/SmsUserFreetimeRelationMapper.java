package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.SmsUserFreetimeRelation;
import com.crayon.youcanpass.model.SmsUserFreetimeRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsUserFreetimeRelationMapper {
    int countByExample(SmsUserFreetimeRelationExample example);

    int deleteByExample(SmsUserFreetimeRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsUserFreetimeRelation record);

    int insertSelective(SmsUserFreetimeRelation record);

    List<SmsUserFreetimeRelation> selectByExample(SmsUserFreetimeRelationExample example);

    SmsUserFreetimeRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsUserFreetimeRelation record, @Param("example") SmsUserFreetimeRelationExample example);

    int updateByExample(@Param("record") SmsUserFreetimeRelation record, @Param("example") SmsUserFreetimeRelationExample example);

    int updateByPrimaryKeySelective(SmsUserFreetimeRelation record);

    int updateByPrimaryKey(SmsUserFreetimeRelation record);
}