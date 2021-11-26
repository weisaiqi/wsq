package com.lening.service;

import com.github.pagehelper.PageInfo;
import com.lening.pojo.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @作者 奶爸
 * @此方法作用 //TODO
 * @创建时间 2021/11/8 8:42
 * @参数
 * @返回类型
 **/
public interface UserService {
    /***
         * @作者 奶爸
         * @此方法作用 //TODO 登录
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    UsersBean getLogin(UsersBean usersBean, HttpSession session);
    /***
         * @作者 奶爸
         * @此方法作用 //TODO 查询所有菜系
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    PageInfo<MenuVo> selectMenu(Integer pageNum,Integer pageSize);

    /***
         * @作者 奶爸
         * @此方法作用 //TODO 删除菜品
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    String delMenu(Integer menuId);
    /***
         * @作者 奶爸
         * @此方法作用 //TODO 查询所有石材
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    List<FoodMaterialBean> selectFood();
    /***
         * @作者 奶爸
         * @此方法作用 //TODO 查询所有菜系
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    List<TypesBean> selectTypes(Integer pid);
    /***
         * @作者 奶爸
         * @此方法作用 //TODO 添加菜品
         * @创建时间  2021/7/12
         * @参数
         * @返回类型
         **/
    int addMenu(MenuBean menuBean);

}
