package com.stylefeng.guns.rest.modular.user;


import java.io.Serializable;
import java.util.Date;


public class MtimeUserT implements Serializable{

    private Integer uuid;

    private String userName;

    private String userPwd;

    private String nickName;

    private Integer userSex;

    private String birthday;

    private String email;

    private String userPhone;

    private String address;

    private String headUrl;

    private String biography;

    private Integer lifeState;

    private Date beginTime;

    private Date updateTime;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getLifeState() {
        return lifeState;
    }

    public void setLifeState(Integer lifeState) {
        this.lifeState = lifeState;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

//    @Override
//    protected Serializable pkVal() {
//        return this.uuid;
//    }

    @Override
    public String toString() {
        return "MtimeUserT{" +
        "uuid=" + uuid +
        ", userName=" + userName +
        ", userPwd=" + userPwd +
        ", nickName=" + nickName +
        ", userSex=" + userSex +
        ", birthday=" + birthday +
        ", email=" + email +
        ", userPhone=" + userPhone +
        ", address=" + address +
        ", headUrl=" + headUrl +
        ", biography=" + biography +
        ", lifeState=" + lifeState +
        ", beginTime=" + beginTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
