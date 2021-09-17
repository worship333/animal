package com.animal.mapper;

import com.animal.pojo.DwContent;
import com.animal.pojo.DwContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwContentMapper {
    int countByExample(DwContentExample example);

    int deleteByExample(DwContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DwContent record);

    int insertSelective(DwContent record);

    List<DwContent> selectByExampleWithBLOBs(DwContentExample example);

    List<DwContent> selectByExample(DwContentExample example);

    DwContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DwContent record, @Param("example") DwContentExample example);

    int updateByExampleWithBLOBs(@Param("record") DwContent record, @Param("example") DwContentExample example);

    int updateByExample(@Param("record") DwContent record, @Param("example") DwContentExample example);

    int updateByPrimaryKeySelective(DwContent record);

    int updateByPrimaryKeyWithBLOBs(DwContent record);

    int updateByPrimaryKey(DwContent record);
}