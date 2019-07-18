package com.stylefeng.guns.rest.common.persistence.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import com.stylefeng.guns.rest.modular.user.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.RegisterInfo;
import com.stylefeng.guns.rest.modular.user.UpdateInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-07-16
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {
        MtimeUserT queryUserByUsername(@Param("name")String username);

        int insertUser(@Param("register") RegisterInfo registerInfo);

        int updateUser(@Param("update") UpdateInfo updateInfo, @Param("username")String username);
}
