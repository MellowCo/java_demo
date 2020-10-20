package com.li.service;

/**
 * @author li
 * @version 1.0
 * @ClassName IPersonService
 * @date 2019/7/14 17:23
 */

public interface IPersonService {
    /**
     *功能描述 转账
     * @author li
     * @date 2019/7/14
     * @param one 转账方
     * @param two 收款方
     * @param money 多少钱
     * @return void
     */
    void getMoney(int one,int two,int money);
}
