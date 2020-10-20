import com.li.domain.Account;
import com.li.mapper.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Program: mybatis_manyToMany
 * @ClassName: UserDaoTest
 * @Description:
 * @Author: li
 * @Create: 2019-08-19 12:55
 */
public class AccountDaoTest {
    InputStream resource;
    SqlSessionFactory build;
    SqlSession session;
    AccountDao dao;

    @Before
    public void Init() throws IOException {
        resource = Resources.getResourceAsStream("SqlMapperConfig.xml");

        build = new SqlSessionFactoryBuilder().build(resource);

        session = build.openSession();

         dao = session.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        resource.close();
    }

    @Test
    public void findAll(){
        List<Account> all = dao.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }
}
