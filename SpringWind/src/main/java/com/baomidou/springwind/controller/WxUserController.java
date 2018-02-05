package com.baomidou.springwind.controller;

import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springwind.entity.User;
import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/weixin/user")
public class WxUserController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;

    @Autowired
    private LocalUserServiceImpl localUserService;

    @ResponseBody
    @Permission(action = Action.Skip)
    @RequestMapping("/updateList")
    public void getLocalList() throws WxErrorException {
        WxMpUserService userService = this.wxUserService.getUserService();
        List<String> list = new ArrayList<String>();
        WxMpUserList wxMpUsers = userService.userList("");
        List<String> openids = wxMpUsers.getOpenids();
        List<WxMpUser> userInfoList = userService.userInfoList(openids);
        List<WechatUser> listcast = Listcast(userInfoList);
        localUserService.insertOrUpdateBatch(listcast);
    }

    public List<WechatUser> Listcast(List<WxMpUser> userList) {
        List<WechatUser> w_list = new ArrayList<WechatUser>();
        for (WxMpUser u : userList) {
            w_list.add(new WechatUser().cast(u));
        }
        return w_list;
    }

    @Permission(action = Action.Skip)
    @RequestMapping("/list")
    public String list(Model model) {
        return "/weixin/list";
    }

    @ResponseBody
    @Permission("5001")
    @RequestMapping("/getUserList")
    public String getUserList() {
        Page<WechatUser> page = getPage();
        return jsonPage(localUserService.selectPage(page, null));
    }
    @ResponseBody
    @Permission(action = Action.Skip)
    @Login(action = Action.Skip)
    @RequestMapping("/accessCode")
    public void accessCode(HttpServletRequest request) {
        String code = request.getParameter("code");
        System.out.println(code);
        try {
            WxMpOAuth2AccessToken token = wxUserService.oauth2getAccessToken(code);
            WxMpUser wxMpUser = wxUserService.oauth2getUserInfo(token, null);
            System.out.println(wxMpUser);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }

    @Login(action = Action.Skip)
    @RequestMapping("/test")
    public String testUrl() {
        String strurl = "http://zhyonk.tunnel.echomod.cn/weixin/user/accessCode";
        String url = wxUserService.oauth2buildAuthorizationUrl(strurl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
        WxMpUser wxMpUser = null;
        System.out.println(url);
        return "redirect:" + url;
    }
}
