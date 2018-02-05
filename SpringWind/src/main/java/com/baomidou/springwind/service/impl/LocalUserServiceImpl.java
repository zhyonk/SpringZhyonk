package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.WechatUser;
import com.baomidou.springwind.mapper.LocalUserMapper;
import com.baomidou.springwind.service.LocalUserService;
import com.baomidou.springwind.service.support.BaseServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LocalUserServiceImpl extends BaseServiceImpl<LocalUserMapper,WechatUser> implements LocalUserService{

    @Override
    public WechatUser selectUserInfoByOpenid(String openid) {
        WechatUser wechatUser = baseMapper.selectUserInfoByOpenid(openid);

        return wechatUser;
    }

    @Override
    public String selectOpenidByZiOpenid(String openid) {
        String s = baseMapper.selectOpenidByZiOpenid(openid);
        return s;
    }

    @Override
    public void insertOrUpdateRelation(String fuid, String ziid) {
        //说明存在，存在就用update
        if(baseMapper.relationIsExist(ziid)!=0){
            baseMapper.updateRelation(fuid,ziid);
        }else {
            baseMapper.insertRelation(fuid,ziid);
        }
    }

    @Override
    public boolean isRelation(String fuid, String ziid) {
        if (baseMapper.isRelation(fuid,ziid)!=0){
            System.out.println("已经存在父子关系");
            return true;
        }
        return false;
    }

    public void insertRelation(String fuid, String ziid) {
        baseMapper.insertRelation(fuid,ziid);
    }
}
