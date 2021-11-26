package com.lening.controller;/**
 * @作者 奶爸
 * @此方法作用 //TODO
 * @创建时间 2021/11/8 8:47
 * @参数
 * @返回类型
 **/

import com.github.pagehelper.PageInfo;
import com.lening.pojo.*;
import com.lening.service.UserService;
import io.swagger.models.Model;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Types;
import java.util.List;

/**
 * 本类作者是：魏赛奇
 * 创建于2021/11/8 8:47
 * 此类的作用是：xxxx
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    //登录
    @RequestMapping("/getLogin")
    @ResponseBody
    public String getLogin(UsersBean usersBean, HttpSession session){
        UsersBean login = userService.getLogin(usersBean, session);
        if(login!=null){
            return "ok";
        }
        return "no";
    }

    //查询所有菜
    @RequestMapping("/toList")
    public ModelAndView toList(HttpSession session){
        UsersBean user = (UsersBean) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("list");
        PageInfo<MenuVo> pageInfo = userService.selectMenu(0, 5);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    //删除菜品
    @RequestMapping("/delMenu")
    @ResponseBody
    public String delMenu(Integer menuId){
        String s = userService.delMenu(menuId);
        return s;
    }

    //添加菜品
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //查询所有菜系
        List<TypesBean> typesBeans = userService.selectTypes(0);
        //查询所有食材
        List<FoodMaterialBean> foodMaterialBeans = userService.selectFood();
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("types", typesBeans);
        modelAndView.addObject("foods", foodMaterialBeans);
        return modelAndView;
    }

    @RequestMapping("/addMenu")
    @ResponseBody
    public String fileUpload(MenuBean menu,HttpSession session){
//        String filename = file.getOriginalFilename();
//        System.out.println(filename);
//        long l = System.currentTimeMillis();
//        String path="\\"+l+".png";
//        try {
//            InputStream inputStream = file.getInputStream();
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\ttt"+path));
//            byte[] bytes = new byte[1024];
//            int i=0;
//            while (-1!=(i=inputStream.read(bytes))){
//                fileOutputStream.write(bytes, 0, i);
//            }
//            fileOutputStream.close();
//            inputStream.close();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        //修改用户的头像
//        menu.setPic(path);
        menu.setPic("D:/Pictures/js1.PNG");
        UsersBean user = (UsersBean) session.getAttribute("user");
        menu.setUserId(user.getUserId());
        int i = userService.addMenu(menu);
        if(i>0){
            return "ok";
        }
        return "no";
    }

    //渲染派系
    @RequestMapping("/selectTypes")
    @ResponseBody
    public List<TypesBean> selectTypes(Integer pid){
        List<TypesBean> typesBeans = userService.selectTypes(pid);
        return typesBeans;
    }
}
