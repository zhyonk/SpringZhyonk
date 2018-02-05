package com.baomidou.springwind.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.framework.controller.SuperController;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springwind.builder.TextBuilder;
import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/weixin")
public class WechatController extends SuperController{

    @Autowired
    private WeixinService wxService;
    @Autowired
    private LocalUserServiceImpl localUserService;
    @ResponseBody
    @RequestMapping("/getQrCodeImage")
    @Permission(action = Action.Skip)
    @Login(action = Action.Skip)
    public String getQrCodeImage(HttpServletRequest request, @RequestParam(value = "openid", required = false) String openid) {
        Map<String,String> map = new HashMap<String,String>();
        int time = 60*60*24*7;
        try {
            WxMpQrCodeTicket ticket = wxService.getQrcodeService().qrCodeCreateTmpTicket(openid,time);
            String qrcodeUrl = wxService.getQrcodeService().qrCodePictureUrl(ticket.getTicket());
            System.out.println(qrcodeUrl);
            map.put("qrcode",qrcodeUrl);
            map.put("expire_seconds",String.valueOf(time));
            map.put("data",openid);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        return JSON.toJSONString(map);
    }
}
