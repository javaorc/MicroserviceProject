package com.stylefeng.guns.rest.modular.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.modular.user.RegisterInfo;
import com.stylefeng.guns.rest.modular.user.service.IMtimeUserTService;
import com.stylefeng.guns.rest.modular.user.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Service( interfaceClass= RegisterService.class)
@Component
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;
    @Override
    public int insertUser(RegisterInfo registerInfo) {
        return mtimeUserTMapper.insertUser(registerInfo);
    }
}
