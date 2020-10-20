package service.impl;

import dao.IPersonDao;
import entity.Person;
import service.IPersonService;

/**
 * @author li
 * @version 1.0
 * @ClassName PersonServicesImpl
 * @date 2019/7/14 17:23
 */

public class PersonServicesImpl implements IPersonService {
    private IPersonDao dao;

    public void setDao(IPersonDao dao) {
        this.dao = dao;
    }

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
