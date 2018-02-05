package com.baomidou.springwind.service;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.springwind.entity.WechatUser;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public interface LocalUserService extends IService<WechatUser> {

    WechatUser selectUserInfoByOpenid(String openid);

    void insertRelation(String fuid, String ziid);

    String selectOpenidByZiOpenid(String openid);

    void insertOrUpdateRelation(String fuid, String ziid);

    boolean isRelation(String fuid, String ziid);
}
