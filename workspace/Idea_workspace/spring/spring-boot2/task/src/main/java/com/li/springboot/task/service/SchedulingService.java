package com.li.springboot.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-15 15:53
 */
@Service
public class SchedulingService {

    /*
     * second , minute, hour, day of month, month and day of week.
     * <p>E.g. {@code "0 * * * * MON-FRI"} means once per minute on weekdays
     */
    @Scheduled(cron = "0/2 * * * * *")
    public void scheduling(){
        System.out.println("启动>>>");
    }
}
