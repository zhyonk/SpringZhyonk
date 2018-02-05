package com.baomidou.springwind.service;

import com.baomidou.springwind.entity.Game;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-04
 */
public interface IGameService extends IService<Game> {

    List<Game> selectGameList();
}
