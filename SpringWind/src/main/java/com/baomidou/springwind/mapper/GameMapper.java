package com.baomidou.springwind.mapper;

import com.baomidou.springwind.entity.Game;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-04
 */
public interface GameMapper extends BaseMapper<Game> {

    List<Game> selectGameList();
}