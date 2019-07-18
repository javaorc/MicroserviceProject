package com.stylefeng.guns.rest.modular.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.modular.user.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.UpdateInfo;
import com.stylefeng.guns.rest.modular.user.UpdateInfoShowBack;
import com.stylefeng.guns.rest.modular.user.UserInfo;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author cskaoyan
 * @since 2019-07-16
 */
@Service( interfaceClass= IMtimeUserTService.class)
@Component
public class MtimeUserTServiceImpl implements IMtimeUserTService {
    @Autowired(required = false)
    MtimeUserTMapper mtimeUserTMapper;
    @Override
    public boolean queryUserByUsername(String username) {
        MtimeUserT mtimeUserT =mtimeUserTMapper.queryUserByUsername(username);

        if(mtimeUserT==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean isUser(String username, String password) {
        MtimeUserT mtimeUserT = mtimeUserTMapper.queryUserByUsername(username);
        if(mtimeUserT==null){
            return false;
        }
        if(password.equals(mtimeUserT.getUserPwd())){
            return true;
        }
        return false;
    }

    @Override
    public UserInfo getUserInfoByUsername(String username) {
        MtimeUserT mtimeUserT =mtimeUserTMapper.queryUserByUsername(username);
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(mtimeUserT,userInfo);
        userInfo.setUsername(mtimeUserT.getUserName());
        userInfo.setNickname(mtimeUserT.getNickName());
        userInfo.setHeadAddress(mtimeUserT.getHeadUrl());
        userInfo.setSex(mtimeUserT.getUserSex());
        return userInfo;
    }

    @Override
    public UpdateInfoShowBack updateAndGetInfoShowBack(UpdateInfo updateInfo,String username) {
        //mtimeUserTMapper.updateUser(updateInfo,username)
        int update = mtimeUserTMapper.updateUser(updateInfo,username);
        if(update>0){
            MtimeUserT mtimeUserT = mtimeUserTMapper.queryUserByUsername(username);
            if(mtimeUserT!=null){
            UpdateInfoShowBack updateInfoShowBack = new UpdateInfoShowBack();
            BeanUtils.copyProperties(mtimeUserT,updateInfoShowBack);
            updateInfoShowBack.setId(mtimeUserT.getUuid());
            updateInfoShowBack.setUsername(mtimeUserT.getUserName());
            updateInfoShowBack.setPhone(mtimeUserT.getUserPhone());
            updateInfoShowBack.setNickname(mtimeUserT.getNickName());
            updateInfoShowBack.setSex(mtimeUserT.getUserSex());
            updateInfoShowBack.setHeadAddress(mtimeUserT.getHeadUrl());
            updateInfoShowBack.setCreateTime(mtimeUserT.getBeginTime());
            updateInfoShowBack.setUpdateTime(mtimeUserT.getUpdateTime());
            return updateInfoShowBack;}
            return null;
        }
        return null;
    }
}
