package com.baomidou.springwind.controller;

import com.baomidou.framework.controller.SuperController;
import com.baomidou.springwind.entity.Game;
import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.service.impl.GameServiceImpl;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private GameServiceImpl gameService;

    @ResponseBody
    @RequestMapping("/selectGameList")
    public String selectGameList(HttpServletResponse response, HttpServletRequest request) {
        List<Game> games = gameService.selectGameList();
        return toJson(games);
    }
    @ResponseBody
    @RequestMapping("/selectJishiById")
    public String selectJishiById(HttpServletResponse response, HttpServletRequest request,@RequestParam(value = "jishiid", required = false) String jishiid) {
        Game game = gameService.selectJishiById(jishiid);
        return toJson(game);
    }
    @RequestMapping(value="/report/{jishiid}",method = RequestMethod.GET)
    public String report(Model model, HttpServletResponse response, @PathVariable("jishiid")String jishiid, HttpServletRequest request) throws WxErrorException {

        return "/wx/jishiinfo";
    }
}
