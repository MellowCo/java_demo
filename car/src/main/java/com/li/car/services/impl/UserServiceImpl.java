package com.li.car.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.car.entity.User;
import com.li.car.mapper.UserMapper;
import com.li.car.services.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 12:28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
