package com.baomidou.springwind.service;

import com.baomidou.springwind.entity.Banner;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-05
 */
public interface IBannerService extends IService<Banner> {

    List<Banner> selectBannerList();
}
