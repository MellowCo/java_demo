import com.li.damain.User;
import com.li.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @Program: ssm1
 * @ClassName: TestMybatis
 * @Description:
 * @Author: li
 * @Create: 2019-08-04 15:12
 */

@ContextConfiguration(locations = {"classpath:applicaContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMybatis {
    @Autowired
    UserServices services;

    @Test
    public void test1() throws IOException {
        System.out.println(services.findAll());
       }

    @Test
    public void test2() throws IOException {
        services.update(new User(1,"li","nan"));
        System.out.println(services.findAll());
    }
}
