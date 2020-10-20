package com.li.provider.service.impl;

import com.li.provider.service.TickerService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-16 16:13
 */
@org.springframework.stereotype.Service //放入spring容器
@Service //通过dubbo的@Service注册到zookeeper中
public class TickerServiceImpl implements TickerService {

    @Override
    public String sellTic() {
        return "一张票";
    }
}
