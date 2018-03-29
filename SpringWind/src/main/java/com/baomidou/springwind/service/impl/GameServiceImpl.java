package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.Game;
import com.baomidou.springwind.mapper.GameMapper;
import com.baomidou.springwind.service.IGameService;
import com.baomidou.springwind.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-04
 */
@Service
public class GameServiceImpl extends BaseServiceImpl<GameMapper, Game> implements IGameService {

    @Override
    public List<Game> selectGameList() {
        List<Game> list = baseMapper.selectGameList();
        return list;
    }

    @Override
    public Game selectJishiById(String jishiid) {
        Game game = baseMapper.selectJishiById(jishiid);
        return game;
    }
}
