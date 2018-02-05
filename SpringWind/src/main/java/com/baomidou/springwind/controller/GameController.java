package com.baomidou.springwind.controller;

import com.baomidou.framework.controller.SuperController;
import com.baomidou.springwind.entity.Game;
import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.service.impl.GameServiceImpl;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Wrapper;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController extends SuperController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;

    @Autowired
    private LocalUserServiceImpl localUserService;

    @Autowired
    private GameServiceImpl gameService;

    @ResponseBody
    @RequestMapping("/selectGameList")
    public String selectGameList(HttpServletResponse response, HttpServletRequest request) {
        List<Game> games = gameService.selectGameList();
        return toJson(games);
    }
}
