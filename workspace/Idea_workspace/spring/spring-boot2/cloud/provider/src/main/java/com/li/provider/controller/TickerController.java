package com.li.provider.controller;

import com.li.provider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-16 17:53
 */
@RestController
public class TickerController {

    @Autowired
    TicketService service;

    @GetMapping("/ticket2")
    public String ticket(){
        return service.getTicket();
    }
}
