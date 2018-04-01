package com.baomidou.springwind.controller;


import com.baomidou.framework.controller.SuperController;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.springwind.builder.TextBuilder;
import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wx")
public class WxIndexController extends SuperController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;

    @Autowired
    private LocalUserServiceImpl localUserService;

    @RequestMapping("/chargeMenu")
    @Permission(action = Action.Skip)
    @Login(action = Action.Skip)
    public String chargeMenu(Model model, HttpServletRequest request1) {
        WxMenu menu = new WxMenu();
        List menulist = new ArrayList<WxMenuButton>();
        WxMenuButton button1 = new WxMenuButton();
        WxMenuButton button2 = new WxMenuButton();
        WxMenuButton button3 = new WxMenuButton();
        button1.setName("美甲预约");
//        button2.setName("拼团美甲");
        button3.setName("生成二维码");
        button1.setType(WxConsts.MenuButtonType.VIEW);
        button2.setType(WxConsts.MenuButtonType.VIEW);
        button3.setType(WxConsts.MenuButtonType.CLICK);

        button1.setUrl("http://zhyonk.tunnel.echomod.cn/wx/zhyonk");
        button2.setUrl("http://zhyonk.tunnel.echomod.cn/");
        button3.setKey("二维码正在生成");
        menulist.add(button1);
        menulist.add(button2);
//        menulist.add(button3);
        menu.setButtons(menulist);
        try {
            String s = wxUserService.getMenuService().menuCreate(menu);
            logger.info("菜单创建成功");
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "/index";
    }




    @Login(action = Action.Skip)
    @Permission(action = Action.Skip)
    @RequestMapping("/zhyonk")
    public String testUrl() {
        String strurl = "http://zhyonk.tunnel.echomod.cn/wx/accessCode";
        String url = wxUserService.oauth2buildAuthorizationUrl(strurl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        WxMpUser wxMpUser = null;
        System.out.println(url);
        return "redirect:" + url;
    }

    @RequestMapping("/accessCode")
    @Permission(action = Action.Skip)
    @Login(action = Action.Skip)
    public String accessCode(Model model, HttpServletRequest request1) {
        String code = request1.getParameter("code");
        System.out.println(code);
        try {
            WxMpOAuth2AccessToken token = wxUserService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxUserService.oauth2getUserInfo(token, null);
            WechatUser wuser = new WechatUser().cast(wxMpUser);
            return redirectTo("index.html?openid=" + wuser.getOpenId());
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "/zhyonk";
    }

    @ResponseBody
    @RequestMapping("/selectUserInfo")
    public String selectUserInfo(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies);
        for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(), "openid")) {
                System.out.println(cookie.getValue());
                WechatUser wechatUser = localUserService.selectUserInfoByOpenid(cookie.getValue());
                return toJson(wechatUser);
            }
        }
        return "请先授权登录";
    }


    @RequestMapping("/index")
    public String index(Model model, HttpServletResponse response, @RequestParam(value = "openid", required = false) String openid) throws WxErrorException {
        System.out.println("index");
        Cookie cookie = new Cookie("openid", openid);
        cookie.setPath("/");
        cookie.setMaxAge(2 * 60 * 60);
        response.addCookie(cookie);
        return "/wx/index";
    }

    @RequestMapping("/classify")
    public String classify(Model model, HttpServletResponse response, @RequestParam(value = "classify", required = false) String classify) throws WxErrorException {

        return "/wx/"+classify;
    }
}
