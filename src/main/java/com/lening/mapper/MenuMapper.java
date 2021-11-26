package com.lening.mapper;

import com.lening.pojo.MenuBean;
import com.lening.pojo.MenuBeanExample;
import com.lening.pojo.MenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    long countByExample(MenuBeanExample example);

    int deleteByExample(MenuBeanExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(MenuBean record);

    int insertSelective(MenuBean record);

    List<MenuBean> selectByExample(MenuBeanExample example);

    MenuBean selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") MenuBean record, @Param("example") MenuBeanExample example);

    int updateByExample(@Param("record") MenuBean record, @Param("example") MenuBeanExample example);

    int updateByPrimaryKeySelective(MenuBean record);

    int updateByPrimaryKey(MenuBean record);

    //查询所有菜系
    List<MenuVo> selectMenu();
    //添加菜品
    int addMenu(MenuBean menuBean);
}