package com.animal.mapper;

import com.animal.pojo.DwItemDesc;
import com.animal.pojo.DwItemDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwItemDescMapper {
    int countByExample(DwItemDescExample example);

    int deleteByExample(DwItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(DwItemDesc record);

    int insertSelective(DwItemDesc record);

    List<DwItemDesc> selectByExampleWithBLOBs(DwItemDescExample example);

    List<DwItemDesc> selectByExample(DwItemDescExample example);

    DwItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") DwItemDesc record, @Param("example") DwItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") DwItemDesc record, @Param("example") DwItemDescExample example);

    int updateByExample(@Param("record") DwItemDesc record, @Param("example") DwItemDescExample example);

    int updateByPrimaryKeySelective(DwItemDesc record);

    int updateByPrimaryKeyWithBLOBs(DwItemDesc record);

    int updateByPrimaryKey(DwItemDesc record);
}