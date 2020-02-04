package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.SmsFreetime;
import com.crayon.youcanpass.model.SmsFreetimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsFreetimeMapper {
    int countByExample(SmsFreetimeExample example);

    int deleteByExample(SmsFreetimeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsFreetime record);

    int insertSelective(SmsFreetime record);

    List<SmsFreetime> selectByExample(SmsFreetimeExample example);

    SmsFreetime selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsFreetime record, @Param("example") SmsFreetimeExample example);

    int updateByExample(@Param("record") SmsFreetime record, @Param("example") SmsFreetimeExample example);

    int updateByPrimaryKeySelective(SmsFreetime record);

    int updateByPrimaryKey(SmsFreetime record);
}