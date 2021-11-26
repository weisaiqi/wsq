package com.lening.service.Impl;/**
 * @作者 奶爸
 * @此方法作用 //TODO
 * @创建时间 2021/11/8 8:43
 * @参数
 * @返回类型
 **/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.mapper.FoodMaterialMapper;
import com.lening.mapper.MenuMapper;
import com.lening.mapper.TypesMapper;
import com.lening.mapper.UsersMapper;
import com.lening.pojo.*;
import com.lening.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 本类作者是：魏赛奇
 * 创建于2021/11/8 8:43
 * 此类的作用是：xxxx
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private TypesMapper typesMapper;
    @Autowired
    private FoodMaterialMapper foodMaterialMapper;
    /***
     * @作者 奶爸
     * @此方法作用 //TODO 登录
     * @创建时间 2021/7/12
     * @参数
     * @返回类型
     *
     * @param usersBean*/
    @Override
    public UsersBean getLogin(UsersBean usersBean, HttpSession session) {
            UsersBean login = usersMapper.getLogin(usersBean);
            if(login!=null){
                session.setAttribute("user", login);
                return login;
            }
            return null;

    }

    /***
     * @作者 奶爸
     * @此方法作用 //TODO 查询所有菜系
     * @创建时间 2021/7/12
     * @参数
     * @返回类型
     **/
    @Override
    public PageInfo<MenuVo> selectMenu(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MenuVo> menuVos = menuMapper.selectMenu();
        PageInfo<MenuVo> pageInfo=new PageInfo<>(menuVos);
        return pageInfo;
    }

    /***
     * @作者 奶爸
     * @此方法作用 //TODO 删除菜品
     * @创建时间 2021/7/12
     * @参数
     * @返回类型
     *
     * @param menuId*/
    @Override
    public String delMenu(Integer menuId) {
        int i = menuMapper.deleteByPrimaryKey(menuId);
        if(i>0){
            return "ok";
        }
        return "no";
    }

    /***
     * @作者 奶爸
     * @此方法作用 //TODO 查询所有石材
     * @创建时间 2021/7/12
     * @参数
     * @返回类型
     **/
    @Override
    public List<FoodMaterialBean> selectFood() {
        return foodMaterialMapper.selectByExample(null);
    }

    /***
     * @作者 奶爸
     * @此方法作用 //TODO 查询所有菜系
     * @创建时间 2021/7/12
     * @参数
     * @返回类型
     *
     * @param pid*/
    @Override
    public List<TypesBean> selectTypes(Integer pid) {
        return typesMapper.selectTypes(pid);
    }

    /***
     * @作者 奶爸
     * @此方法作用 //TODO 添加菜品
     * @创建时间 2021/7/12
     * @参数
     * @返回类型
     *
     * @param menuBean*/
    @Override
    public int addMenu(MenuBean menuBean) {
        return menuMapper.addMenu(menuBean);
    }
}
