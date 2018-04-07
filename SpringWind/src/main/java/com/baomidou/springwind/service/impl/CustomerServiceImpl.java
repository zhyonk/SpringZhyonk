package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.Customer;
import com.baomidou.springwind.mapper.CustomerMapper;
import com.baomidou.springwind.service.ICustomerService;
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
public class CustomerServiceImpl extends BaseServiceImpl<CustomerMapper, Customer> implements ICustomerService {
	
}
