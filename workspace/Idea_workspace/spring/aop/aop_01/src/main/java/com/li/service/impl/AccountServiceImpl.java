package com.li.service.impl;

import com.li.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void saveAccount() {
        System.out.println("保存用户中......");
    }

    @Override
    public void addAccount(int id) {
        System.out.println("添加用户中......");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除用户中。。。。。");
        return 0;
    }
}
