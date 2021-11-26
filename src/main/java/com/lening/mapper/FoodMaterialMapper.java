package com.lening.mapper;

import com.lening.pojo.FoodMaterialBean;
import com.lening.pojo.FoodMaterialBeanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMaterialMapper {
    long countByExample(FoodMaterialBeanExample example);

    int deleteByExample(FoodMaterialBeanExample example);

    int deleteByPrimaryKey(Integer foodId);

    int insert(FoodMaterialBean record);

    int insertSelective(FoodMaterialBean record);

    List<FoodMaterialBean> selectByExample(FoodMaterialBeanExample example);

    FoodMaterialBean selectByPrimaryKey(Integer foodId);

    int updateByExampleSelective(@Param("record") FoodMaterialBean record, @Param("example") FoodMaterialBeanExample example);

    int updateByExample(@Param("record") FoodMaterialBean record, @Param("example") FoodMaterialBeanExample example);

    int updateByPrimaryKeySelective(FoodMaterialBean record);

    int updateByPrimaryKey(FoodMaterialBean record);
}