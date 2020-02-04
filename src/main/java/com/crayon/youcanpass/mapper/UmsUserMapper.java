package com.crayon.youcanpass.mapper;

import com.crayon.youcanpass.model.UmsUser;
import com.crayon.youcanpass.model.UmsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UmsUserMapper {
    int countByExample(UmsUserExample example);

    int deleteByExample(UmsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UmsUser record);

    int insertSelective(UmsUser record);

    List<UmsUser> selectByExampleWithBLOBs(UmsUserExample example);

    List<UmsUser> selectByExample(UmsUserExample example);

    UmsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UmsUser record, @Param("example") UmsUserExample example);

    int updateByExampleWithBLOBs(@Param("record") UmsUser record, @Param("example") UmsUserExample example);

    int updateByExample(@Param("record") UmsUser record, @Param("example") UmsUserExample example);

    int updateByPrimaryKeySelective(UmsUser record);

    int updateByPrimaryKeyWithBLOBs(UmsUser record);

    int updateByPrimaryKey(UmsUser record);
}