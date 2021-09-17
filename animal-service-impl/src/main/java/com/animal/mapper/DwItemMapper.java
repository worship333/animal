package com.animal.mapper;

import com.animal.pojo.DwItem;
import com.animal.pojo.DwItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwItemMapper {
    int countByExample(DwItemExample example);

    int deleteByExample(DwItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DwItem record);

    int insertSelective(DwItem record);

    List<DwItem> selectByExample(DwItemExample example);

    DwItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DwItem record, @Param("example") DwItemExample example);

    int updateByExample(@Param("record") DwItem record, @Param("example") DwItemExample example);

    int updateByPrimaryKeySelective(DwItem record);

    int updateByPrimaryKey(DwItem record);
}