package com.baomidou.springwind.controller;

import com.baomidou.framework.controller.SuperController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.springwind.entity.Classify;
import com.baomidou.springwind.entity.Goods;
import com.baomidou.springwind.service.impl.GoodsServiceImpl;
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
 * @since 2018-04-07
 */
@Controller
@RequestMapping("/goods")
public class GoodsController  extends SuperController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WeixinService wxUserService;
    @Autowired
    private GoodsServiceImpl goodsService;
    @ResponseBody
    @RequestMapping("/selectGoodsListByXiaoliang")
    public String selectGoodsListByXiaoliang(HttpServletResponse response, HttpServletRequest request) {
        EntityWrapper<Goods> classifyEntityWrapper = new EntityWrapper<>();
        classifyEntityWrapper.where("g_status=0").orderBy("order_count");
        List<Goods> classifies = goodsService.selectList(classifyEntityWrapper);
        return toJson(classifies);
    }

}
