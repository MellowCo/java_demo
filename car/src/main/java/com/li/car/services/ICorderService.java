package com.li.car.services;

import com.baomidou.mybatisplus.extension.service.IService;
import com.li.car.entity.Corder;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 12:26
 */
public interface ICorderService extends IService<Corder> {
    Boolean addOrder(Corder order);
    Boolean getCar(String oid , String cid);
}
