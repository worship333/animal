package com.animal.mapper;

import com.animal.pojo.DwItemCat;
import com.animal.pojo.DwItemCatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwItemCatMapper {
    int countByExample(DwItemCatExample example);

    int deleteByExample(DwItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DwItemCat record);

    int insertSelective(DwItemCat record);

    List<DwItemCat> selectByExample(DwItemCatExample example);

    DwItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DwItemCat record, @Param("example") DwItemCatExample example);

    int updateByExample(@Param("record") DwItemCat record, @Param("example") DwItemCatExample example);

    int updateByPrimaryKeySelective(DwItemCat record);

    int updateByPrimaryKey(DwItemCat record);
}