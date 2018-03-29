package com.baomidou.springwind.service;

import com.baomidou.springwind.entity.Yuyue;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhyonk
 * @since 2018-03-26
 */
public interface IYuyueService extends IService<Yuyue> {
    /**
     * 获取客户的所有预约信息
     * */
    List<Yuyue> selectYuyueList(String kehuid);
    /**
     * 通过预约id获取预约
     * */
    Yuyue selectYuyueById(String yuyueid);
}
