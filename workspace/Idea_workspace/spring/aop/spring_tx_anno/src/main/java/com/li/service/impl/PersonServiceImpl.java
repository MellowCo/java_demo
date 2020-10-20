package com.li.service.impl;

import com.li.dao.IPersonDao;
import com.li.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.li.service.IPersonService;

/**
 * @author li
 * @version 1.0
 * @ClassName PersonServiceImpl
 * @date 2019/7/14 17:23
 */

@Service("personService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
public class PersonServiceImpl implements IPersonService {
    @Autowired
    private IPersonDao dao;


    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void getMoney(int one, int two, int money) {
        Person oneP = dao.queryByID(one).get(0);
        Person twoP = dao.queryByID(two).get(0);

        oneP.setMoney(-money);
        twoP.setMoney(money);

        dao.updateByID(oneP);
        int i = 1/0;
        dao.updateByID(twoP);
    }
}
