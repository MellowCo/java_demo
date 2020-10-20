import com.li.dao.UserMapper;
import com.li.entity.User;
import com.li.entity.UserExample;
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
 * @ClassName: UsermapperTest
 * @Description:
 * @Author: li
 * @Create: 2019-08-19 12:55
 */
public class GerenTest {
    InputStream resource;
    SqlSessionFactory build;
    SqlSession session;
    UserMapper mapper;

    @Before
    public void Init() throws IOException {
        resource = Resources.getResourceAsStream("SqlMapperConfig.xml");

        build = new SqlSessionFactoryBuilder().build(resource);

        session = build.openSession();

        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        session.commit();
        session.close();
        resource.close();
    }

    @Test
    public void findAll(){

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdBetween(41, 43);

        List<User> all = mapper.selectByExample(example);
        // mapper.insert()
        for (User user : all) {
            System.out.println(user);
        }

    }

    // @Test
    // public void findAll2(){
    //     List<User> all = mapper.findUserRole();
    //     for (User user : all) {
    //         System.out.println(user);
    //     }
    //
    // }
}
