package com.baomidou.springwind.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.springwind.entity.WechatUser;
import org.apache.ibatis.annotations.Param;

public interface LocalUserMapper extends BaseMapper<WechatUser>{
    WechatUser selectUserInfoByOpenid(@Param("openid") String openid);

    void insertRelation(@Param("fuid")String fuid, @Param("ziid")String ziid);

    String selectOpenidByZiOpenid(@Param("openid")String openid);

    Integer relationIsExist(@Param("ziid")String ziid);

    void updateRelation(@Param("fuid")String fuid, @Param("ziid")String ziid);

    Integer isRelation(@Param("fuid")String fuid, @Param("ziid")String ziid);
}
