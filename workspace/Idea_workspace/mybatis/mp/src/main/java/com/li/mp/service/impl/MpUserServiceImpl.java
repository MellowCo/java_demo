package com.li.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.mp.dao.MpUserMapper;
import com.li.mp.domain.MpUser;
import com.li.mp.service.IMpUserService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-20 17:30
 */
@Service
public class MpUserServiceImpl extends ServiceImpl<MpUserMapper, MpUser> implements IMpUserService {
}
