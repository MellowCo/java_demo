import com.li.domain.User;
import com.li.mapper.UserDao;
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
public class UserDaoTest {
    InputStream resource;
    SqlSessionFactory build;
    SqlSession session;
    UserDao dao;

    @Before
    public void Init() throws IOException {
        resource = Resources.getResourceAsStream("SqlMapperConfig.xml");

        build = new SqlSessionFactoryBuilder().build(resource);

        session = build.openSession();

         dao = session.getMapper(UserDao.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        resource.close();
    }

    @Test
    public void findAll(){
        List<User> all = dao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test
    public void findAll2(){
        List<User> all = dao.findUserRole();
        for (User user : all) {
            System.out.println(user);
        }

    }
}
