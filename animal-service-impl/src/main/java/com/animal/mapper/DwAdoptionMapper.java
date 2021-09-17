package com.animal.mapper;

import com.animal.pojo.DwAdoption;
import com.animal.pojo.DwAdoptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwAdoptionMapper {
    int countByExample(DwAdoptionExample example);

    int deleteByExample(DwAdoptionExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(DwAdoption record);

    int insertSelective(DwAdoption record);

    List<DwAdoption> selectByExample(DwAdoptionExample example);

    DwAdoption selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") DwAdoption record, @Param("example") DwAdoptionExample example);

    int updateByExample(@Param("record") DwAdoption record, @Param("example") DwAdoptionExample example);

    int updateByPrimaryKeySelective(DwAdoption record);

    int updateByPrimaryKey(DwAdoption record);
}