package com.animal.mapper;

import com.animal.pojo.DwAdoptionItem;
import com.animal.pojo.DwAdoptionItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DwAdoptionItemMapper {
    int countByExample(DwAdoptionItemExample example);

    int deleteByExample(DwAdoptionItemExample example);

    int deleteByPrimaryKey(String id);

    int insert(DwAdoptionItem record);

    int insertSelective(DwAdoptionItem record);

    List<DwAdoptionItem> selectByExample(DwAdoptionItemExample example);

    DwAdoptionItem selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DwAdoptionItem record, @Param("example") DwAdoptionItemExample example);

    int updateByExample(@Param("record") DwAdoptionItem record, @Param("example") DwAdoptionItemExample example);

    int updateByPrimaryKeySelective(DwAdoptionItem record);

    int updateByPrimaryKey(DwAdoptionItem record);
}