package com.animal.mapper;

import com.animal.pojo.DwContentCategory;
import com.animal.pojo.DwContentCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwContentCategoryMapper {
    int countByExample(DwContentCategoryExample example);

    int deleteByExample(DwContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DwContentCategory record);

    int insertSelective(DwContentCategory record);

    List<DwContentCategory> selectByExample(DwContentCategoryExample example);

    DwContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DwContentCategory record, @Param("example") DwContentCategoryExample example);

    int updateByExample(@Param("record") DwContentCategory record, @Param("example") DwContentCategoryExample example);

    int updateByPrimaryKeySelective(DwContentCategory record);

    int updateByPrimaryKey(DwContentCategory record);
}