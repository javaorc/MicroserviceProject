package com.stylefeng.guns.jwt;

import com.alibaba.fastjson.JSON;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.SimpleObject;
import com.stylefeng.guns.rest.modular.auth.converter.BaseTransferEntity;
import com.stylefeng.guns.rest.modular.auth.security.impl.Base64SecurityAction;
import com.stylefeng.guns.rest.modular.user.RegisterInfo;
import com.stylefeng.guns.rest.modular.user.UpdateInfo;
import com.stylefeng.guns.rest.modular.user.UserInfo;

/**
 * jwt测试
 *
 * @author fengshuonan
 * @date 2017-08-21 16:34
 */
public class DecryptTest {

    public static void main(String[] args) {

        String salt = "kzj9yh";

        UpdateInfo updateInfo = new UpdateInfo();
        updateInfo.setUuid(2);
        updateInfo.setNickname("li");
        updateInfo.setEmail("123@qq.com");
        updateInfo.setPhone("121312");
        updateInfo.setSex(1);
        updateInfo.setBirthday("21");
        updateInfo.setLifeState(1);
        updateInfo.setBiography("wqe");
        updateInfo.setAddress("湖北省武汉市花山镇软件新城c13");

//        RegisterInfo registerInfo = new RegisterInfo();
//        registerInfo.setUsername("admin");
//        registerInfo.setPassword("admin");
//        registerInfo.setAddress("asd");
//        registerInfo.setEmail("123@qq.com");
//        registerInfo.setPhone("111222333");


        String jsonString = JSON.toJSONString(updateInfo);
        String encode = new Base64SecurityAction().doAction(jsonString);
        String md5 = MD5Util.encrypt(encode + salt);

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(md5);

        System.out.println(JSON.toJSONString(baseTransferEntity));
    }
}
