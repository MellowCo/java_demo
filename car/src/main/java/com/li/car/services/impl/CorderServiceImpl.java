package com.li.car.services.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.li.car.entity.CarPort;
import com.li.car.entity.Corder;
import com.li.car.mapper.CarPortMapper;
import com.li.car.mapper.CorderMapper;
import com.li.car.services.ICorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 12:28
 */
@Service
@Transactional
public class CorderServiceImpl extends ServiceImpl<CorderMapper, Corder> implements ICorderService {
    @Autowired
    private CarPortMapper carPortMapper;
    @Autowired
    private CorderMapper corderMapper;

    //需要的是读写型事务配置

    /**
     * @Description: 添加订单
     * @Param: [order]
     * @return: java.lang.Boolean
     */
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Boolean addOrder(Corder order) {

        //更改车辆状态
        int update = carPortMapper.update(null, Wrappers.<CarPort>lambdaUpdate()
                .eq(CarPort::getCid, order.getCid()).set(CarPort::getStatus, 0));
        //保存订单
        int insert = corderMapper.insert(order);

        return update > 0 && insert > 0;
    }

    /**
     * @Description: 还车
     * @Param: [oid, cid]
     * @return:
     */
    //需要的是读写型事务配置
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Boolean getCar(String oid, String cid) {
        //更新车辆状态
        CarPort car = new CarPort();
        car.setCid(cid);
        car.setStatus(1);
        int i = carPortMapper.updateById(car);
        //更新订单状态
        Corder order = new Corder();
        order.setOid(oid);
        order.setStatus(-1);
        int i1 = corderMapper.updateById(order);

        return i > 0 && i1 > 0;
    }
}
