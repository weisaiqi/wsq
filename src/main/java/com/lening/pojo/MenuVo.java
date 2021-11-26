package com.lening.pojo;/**
 * @作者 奶爸
 * @此方法作用 //TODO
 * @创建时间 2021/11/8 9:10
 * @参数
 * @返回类型
 **/

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 本类作者是：魏赛奇
 * 创建于2021/11/8 9:10
 * 此类的作用是：xxxx
 */
public class MenuVo {

    private Integer menuId;
    private String menuName;
    private String typeName;
    private String t2Name;
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd HH:ss:mm")
    private Date publishTime;
    private Integer popularity;
    private String foodName;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getT2Name() {
        return t2Name;
    }

    public void setT2Name(String t2Name) {
        this.t2Name = t2Name;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @Override
    public String toString() {
        return "MenuVo{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", typeName='" + typeName + '\'' +
                ", t2Name='" + t2Name + '\'' +
                ", publishTime=" + publishTime +
                ", popularity=" + popularity +
                ", foodName='" + foodName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
