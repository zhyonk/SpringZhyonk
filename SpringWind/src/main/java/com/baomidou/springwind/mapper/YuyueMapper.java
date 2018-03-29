package com.baomidou.springwind.mapper;

import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.entity.Yuyue;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhyonk
 * @since 2018-03-26
 */
public interface YuyueMapper extends BaseMapper<Yuyue> {
    List<Yuyue> selectYuyueList(@Param("kehuid") String kehuid);

    Yuyue selectYuyueById(@Param("yuyueid")String yuyueid);
}