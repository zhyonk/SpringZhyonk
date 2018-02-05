package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.Banner;
import com.baomidou.springwind.entity.Game;
import com.baomidou.springwind.mapper.BannerMapper;
import com.baomidou.springwind.service.IBannerService;
import com.baomidou.springwind.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-05
 */
@Service
public class BannerServiceImpl extends BaseServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Override
    public List<Banner> selectBannerList() {
        List<Banner> list = baseMapper.selectBannerList();
        return list;
    }
}
