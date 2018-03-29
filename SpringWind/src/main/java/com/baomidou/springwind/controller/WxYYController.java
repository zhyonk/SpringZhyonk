package com.baomidou.springwind.controller;

import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wx/yy")
public class WxYYController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;

    @Autowired
    private LocalUserServiceImpl localUserService;
    //获取预约信息详情
    @ResponseBody
    @Permission(action = Action.Skip)
    @RequestMapping("/getYuyueInfo")
    public void getYuyueInfo() throws WxErrorException {
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
    //立即预约
    @Permission(action = Action.Skip)
    @RequestMapping("/startYuYue")
    public String startYuYue(Model model) {



        return "/weixin/list";
    }
    //取消预约
    @ResponseBody
    @Permission("5001")
    @RequestMapping("/cancleYuYue")
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

//    @Login(action = Action.Skip)
//    @RequestMapping("/test")
//    public String testUrl() {
//        String strurl = "http://zhyonk.tunnel.echomod.cn/weixin/user/accessCode";
//        String url = wxUserService.oauth2buildAuthorizationUrl(strurl, WxConsts.OAuth2Scope.SNSAPI_USERINFO, null);
//        WxMpUser wxMpUser = null;
//        System.out.println(url);
//        return "redirect:" + url;
//    }
}
