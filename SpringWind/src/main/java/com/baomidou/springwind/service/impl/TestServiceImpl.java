package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.Test;
import com.baomidou.springwind.mapper.TestMapper;
import com.baomidou.springwind.service.ITestService;
import com.baomidou.springwind.service.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhyonk
 * @since 2018-04-07
 */
@Service
public class TestServiceImpl extends BaseServiceImpl<TestMapper, Test> implements ITestService {
	
}
