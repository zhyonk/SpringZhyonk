package com.baomidou.springwind.service.impl;

import com.baomidou.springwind.entity.Address;
import com.baomidou.springwind.mapper.AddressMapper;
import com.baomidou.springwind.service.IAddressService;
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
public class AddressServiceImpl extends BaseServiceImpl<AddressMapper, Address> implements IAddressService {
	
}
