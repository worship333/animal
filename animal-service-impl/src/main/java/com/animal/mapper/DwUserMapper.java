package com.animal.mapper;

import com.animal.pojo.DwUser;
import com.animal.pojo.DwUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwUserMapper {
    int countByExample(DwUserExample example);

    int deleteByExample(DwUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DwUser record);

    int insertSelective(DwUser record);

    List<DwUser> selectByExample(DwUserExample example);

    DwUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DwUser record, @Param("example") DwUserExample example);

    int updateByExample(@Param("record") DwUser record, @Param("example") DwUserExample example);

    int updateByPrimaryKeySelective(DwUser record);

    int updateByPrimaryKey(DwUser record);
}