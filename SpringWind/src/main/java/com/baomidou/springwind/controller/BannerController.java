package com.baomidou.springwind.controller;

import com.baomidou.framework.controller.SuperController;
import com.baomidou.springwind.entity.Banner;
import com.baomidou.springwind.entity.Game;
import com.baomidou.springwind.service.impl.BannerServiceImpl;
import com.baomidou.springwind.service.impl.GameServiceImpl;
import com.baomidou.springwind.service.impl.LocalUserServiceImpl;
import com.baomidou.springwind.service.impl.WeixinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhyonk
 * @since 2018-02-05
 */
@Controller
@RequestMapping("/banner")
public class BannerController extends SuperController{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;

    @Autowired
    private LocalUserServiceImpl localUserService;

    @Autowired
    private BannerServiceImpl bannerService;

    @ResponseBody
    @RequestMapping("/selectBannerList")
    public String selectBannerList(HttpServletResponse response, HttpServletRequest request) {
        List<Banner> banners = bannerService.selectBannerList();
        return toJson(banners);
    }
}
