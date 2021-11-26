package com.lening.mapper;

import com.lening.pojo.UsersBean;
import com.lening.pojo.UsersBeanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    long countByExample(UsersBeanExample example);

    int deleteByExample(UsersBeanExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UsersBean record);

    int insertSelective(UsersBean record);

    List<UsersBean> selectByExample(UsersBeanExample example);

    UsersBean selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UsersBean record, @Param("example") UsersBeanExample example);

    int updateByExample(@Param("record") UsersBean record, @Param("example") UsersBeanExample example);

    int updateByPrimaryKeySelective(UsersBean record);

    int updateByPrimaryKey(UsersBean record);

    /***
         * @作者 奶爸
         * @此方法作用 //TODO  登录
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    UsersBean getLogin(UsersBean usersBean);
}