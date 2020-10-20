package com.li.service;

public interface IAccountService {
    /**
     * 保存用户
     */
    void saveAccount();

    /**
     * 添加用户
     */
    void addAccount(int id);

    /**
     * 删除用户
     */
    int deleteAccount();
}
