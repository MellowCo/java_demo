package com.li.car.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.car.entity.CarPort;
import com.li.car.mapper.CarPortMapper;
import com.li.car.services.ICarPortService;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 12:28
 */
@Service
public class CarPortServiceImpl extends ServiceImpl<CarPortMapper, CarPort> implements ICarPortService {
}
