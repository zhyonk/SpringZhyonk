package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.Yuyue;
import com.baomidou.springwind.mapper.YuyueMapper;
import com.baomidou.springwind.service.IYuyueService;
import com.baomidou.springwind.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhyonk
 * @since 2018-03-26
 */
@Service
public class YuyueServiceImpl extends BaseServiceImpl<YuyueMapper, Yuyue> implements IYuyueService {

    @Override
    public List<Yuyue> selectYuyueList(String kehuid) {
        List<Yuyue> yuyues = baseMapper.selectYuyueList(kehuid);
        return yuyues;
    }

    @Override
    public Yuyue selectYuyueById(String yuyueid) {
        Yuyue yuyue = baseMapper.selectYuyueById(yuyueid);
        return yuyue;
    }
}
