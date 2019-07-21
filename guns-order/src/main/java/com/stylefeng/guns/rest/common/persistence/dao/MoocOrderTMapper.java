package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MoocOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Past;
import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author cskaoyan
 * @since 2019-07-19
 */
public interface MoocOrderTMapper extends BaseMapper<MoocOrderT> {
        List<MoocOrderT> getOrdersByUid(@Param("uid")Integer userId);

        List<MoocOrderT> getOrdersByFieldId(@Param("fid")Integer filedId);
}
