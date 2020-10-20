package com.li.consumer.service;

import com.li.provider.service.TickerService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-16 16:22
 */
@Service //放入spring容器
public class ConsumerService {

    @Reference //远程使用
    TickerService tickerService;

    public void consumer() {
        System.out.println("用户买到了:" + tickerService.sellTic());
    }
}
