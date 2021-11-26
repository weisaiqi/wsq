package com.lening.mapper;

import com.lening.pojo.TypesBean;
import com.lening.pojo.TypesBeanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypesMapper {
    long countByExample(TypesBeanExample example);

    int deleteByExample(TypesBeanExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(TypesBean record);

    int insertSelective(TypesBean record);

    List<TypesBean> selectByExample(TypesBeanExample example);

    TypesBean selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") TypesBean record, @Param("example") TypesBeanExample example);

    int updateByExample(@Param("record") TypesBean record, @Param("example") TypesBeanExample example);

    int updateByPrimaryKeySelective(TypesBean record);

    int updateByPrimaryKey(TypesBean record);

    //查询所有菜系
    List<TypesBean> selectTypes(Integer pid);
}