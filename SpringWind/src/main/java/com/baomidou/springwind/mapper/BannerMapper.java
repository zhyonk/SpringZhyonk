package com.baomidou.springwind.mapper;

import com.baomidou.springwind.entity.Banner;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-05
 */
public interface BannerMapper extends BaseMapper<Banner> {

    List<Banner> selectBannerList();

}