package com.stylefeng.guns.rest.modular.user.service;

import com.stylefeng.guns.rest.modular.user.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.UpdateInfo;
import com.stylefeng.guns.rest.modular.user.UpdateInfoShowBack;
import com.stylefeng.guns.rest.modular.user.UserInfo;


public interface IMtimeUserTService {
    boolean queryUserByUsername(String username);

    boolean isUser(String username,String password);

    UserInfo getUserInfoByUsername(String username);

    UpdateInfoShowBack updateAndGetInfoShowBack(UpdateInfo updateInfo,String username);

}
