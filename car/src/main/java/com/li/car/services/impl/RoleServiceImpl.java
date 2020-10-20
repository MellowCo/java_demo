package com.li.car.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.car.entity.Role;
import com.li.car.mapper.RoleMapper;
import com.li.car.services.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 12:28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
