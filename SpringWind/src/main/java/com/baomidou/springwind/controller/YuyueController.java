package com.baomidou.springwind.controller;

import com.baomidou.framework.controller.SuperController;
import com.baomidou.kisso.annotation.Action;
import com.baomidou.kisso.annotation.Login;
import com.baomidou.kisso.annotation.Permission;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springwind.entity.Game;
import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.entity.Yuyue;
import com.baomidou.springwind.service.impl.GameServiceImpl;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import com.baomidou.springwind.service.impl.YuyueServiceImpl;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpUserService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhyonk
 * @since 2018-03-26
 */
@Controller
@RequestMapping("/yuyue")
public class YuyueController extends SuperController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;

    @Autowired
    private YuyueServiceImpl yuyueService;

    @Autowired
    private GameServiceImpl gameService;
    @Autowired
    private LocalUserServiceImpl localUserService;

    //获取预约信息详情
    @ResponseBody
    @Permission(action = Action.Skip)
    @RequestMapping("/getYuyueInfo")
    public String getYuyueInfo(Model model, HttpServletResponse response, @RequestParam(value = "kehuid", required = false) String kehuid) throws WxErrorException {
        //根据客户的openid获取该客户所有预约信息。
        List<Yuyue> list = yuyueService.selectYuyueList(kehuid);
        return toJson(list);
    }

    //立即预约
    @Permission(action = Action.Skip)
    @RequestMapping("/startYuYue")
    public String startYuYue(Model model, HttpServletResponse response, @RequestParam(value = "pnumber", required = false) String pnumber, @RequestParam(value = "kehuname", required = false) String name, @RequestParam(value = "jishiid", required = false) String jishiid, @RequestParam(value = "yytime", required = false) String yytime, @RequestParam(value = "yyType", required = false) String yyType, @RequestParam(value = "location", required = false) String location) {
        String kehuid = getKeHuId();
        Integer strtype = 1;
        Integer defaultStatusNumber = 0;



        sendJiShiMessage(jishiid, name, "恭喜您哦！", "预约上门", yytime, pnumber, "客户地址:莲湖区梨园路御园温泉小区E8-2709");
//        Yuyue yuyue = new Yuyue();
//        yuyue.setKehuid(kehuid);
//        yuyue.setJishiid(jishiid);
//        yuyue.setStatus(1);
//        yuyue.setCrTime(new Date());
//        yuyue.setYytime(Integer.parseInt(yytime));
//        yuyue.setYyType(Integer.parseInt(yyType));
//        yuyue.setLocation("巴拉巴拉。。。");
//        yuyue.setTypeId(1);
//        if (yuyueService.insertOrUpdate(yuyue)) {
//            //success
//            return "weixin/yy/success";
//        } else {
//            return "weixin/yy/field";
//        }
        return null;
    }

    private String getKeHuId() {
        Cookie[] cookies = request.getCookies();
        String kehuid1 = "";
        for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(), "openid")) {
                kehuid1 = cookie.getValue();
            }
        }
        return kehuid1;
    }

    //立即预约
    @Permission(action = Action.Skip)
    @RequestMapping("/location")
    public String location(Model model, HttpServletResponse response, @RequestParam(value = "kehuid", required = false) String kehuid, @RequestParam(value = "jishiid", required = false) String jishiid, @RequestParam(value = "yytime", required = false) String yytime, @RequestParam(value = "yyType", required = false) String yyType, @RequestParam(value = "location", required = false) String location) {
        return "wx/location";
    }

    //查看预约订单
//    @Permission(action = Action.Skip)
    @RequestMapping("/already")
    public String already(Model model, HttpServletResponse response, @RequestParam(value = "kehuid", required = false) String kehuid, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.toString());
        for (Cookie cookie : cookies) {
            if (StringUtils.equals(cookie.getName(), "openid")) {

            }
        }
        return "wx/alreadyYY";
    }

    //进入详情
//    @Permission(action = Action.Skip)
    @RequestMapping("/details")
    public String details(Model model, HttpServletResponse response, @RequestParam(value = "kehuid", required = false) String kehuid, HttpServletRequest request) {
        return "wx/details";
    }




    @RequestMapping("/yuyue")
    public String yuyue(Model model, HttpServletResponse response, @RequestParam(value = "jishiid", required = false) String jishiid, HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies.toString());
//        for (Cookie cookie : cookies) {
//            if (StringUtils.equals(cookie.getName(), "openid")) {
//
//            }
//        }
        return "wx/payorder";
    }

    @RequestMapping("/shopindex")
    public String shopindex(Model model, HttpServletResponse response, @RequestParam(value = "jishiid", required = false) String jishiid, HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies.toString());
//        for (Cookie cookie : cookies) {
//            if (StringUtils.equals(cookie.getName(), "openid")) {
//
//            }
//        }
        return "wx/shopindex";
    }


    @RequestMapping("/payorder")
    public String payorder(Model model, HttpServletResponse response, @RequestParam(value = "jishiid", required = false) String jishiid, HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        System.out.println(cookies.toString());
//        for (Cookie cookie : cookies) {
//            if (StringUtils.equals(cookie.getName(), "openid")) {
//
//            }
//        }
        return "wx/result";
    }

    //取消预约
    @ResponseBody
    @Permission("5001")
    @RequestMapping("/cancleYuYue")
    public String cancleYuYue(@RequestParam(value = "yuyueid", required = false) String yuyueid) {
        Yuyue yuyu = yuyueService.selectYuyueById(yuyueid);
        if (yuyueService.insertOrUpdate(yuyu)) {
            return "success";
        } else {
            return "field";
        }
    }


    public String sendTextmessage(String userid, String text) {
        WxMpKefuMessage message = new WxMpKefuMessage();
        message.setMsgType(WxConsts.MassMsgType.TEXT);
        message.setToUser(userid);
        message.setContent(text);
        try {
            wxUserService.getKefuService().sendKefuMessage(message);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        System.out.println("发送成功");
        return "";
    }

    public String sendUrlmessage(String userid, String text) {
        WxMpKefuMessage.WxArticle article1 = new WxMpKefuMessage.WxArticle();
        article1.setUrl("www.baidu.com");
        article1.setPicUrl("PIC_URL");
        article1.setDescription("Is Really A Happy Day");
        article1.setTitle("Happy Day");

        WxMpKefuMessage.NEWS()
                .toUser("OPENID")
                .addArticle(article1)
                .build();
        return "";
    }

    public String sendTemplatemessage(String userid, String text) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS");
//        WxMpTemplateMessage message = WxMpTemplateMessage.builder().build();

//        message.setToUser(userid);
//        message.setTemplateId("");
//        message.setUrl("");
//        message.getData().add(new WxMpTemplateData("1", text, "#173177"));


        return "";
    }

    //发给技师
    public String sendJiShiMessage(String jishiid, String kehuname, String first, String type, String time, String tel, String location) {

        WxMpTemplateMessage templateMessageToKehu = WxMpTemplateMessage.builder()
                .toUser(jishiid)
                .templateId("0DzvImKcp7RloqYGLaqwaX0wbXm8NsydSksmW6YnQnc")
                .url("www.baidu.com")
                .build();
        try {
            templateMessageToKehu.addData(new WxMpTemplateData("kehuname", kehuname, "#050505"))
                    .addData(new WxMpTemplateData("type", type, "#050505"))
                    .addData(new WxMpTemplateData("first", first, "#F70000"))
                    .addData(new WxMpTemplateData("time", time, "#050505"))
                    .addData(new WxMpTemplateData("kehutel", tel, "#050505"))
                    .addData(new WxMpTemplateData("remark", location, "#050505"));
            String msgId = this.wxUserService.getTemplateMsgService().sendTemplateMsg(templateMessageToKehu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "";
    }

    //发给顾客
    public String sendGuKeMessage(String jishiid, String first, String type, String time, String location) {

        Game game = gameService.selectJishiById(jishiid);
        String name = game.getName();
        String tel = game.getTel();
        WxMpTemplateMessage templateMessageToKehu = WxMpTemplateMessage.builder()
                .toUser(jishiid)
                .templateId("0DzvImKcp7RloqYGLaqwaX0wbXm8NsydSksmW6YnQnc")
                .url("www.baidu.com")
                .build();
        try {
            templateMessageToKehu.addData(new WxMpTemplateData("jishiname", name, "#050505"))
                    .addData(new WxMpTemplateData("type", type, "#050505"))
                    .addData(new WxMpTemplateData("first", first, "#F70000"))
                    .addData(new WxMpTemplateData("time", time, "#050505"))
                    .addData(new WxMpTemplateData("kehutel", tel, "#050505"))
                    .addData(new WxMpTemplateData("remark", location, "#050505"));
            String msgId = this.wxUserService.getTemplateMsgService().sendTemplateMsg(templateMessageToKehu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "";
    }

}
