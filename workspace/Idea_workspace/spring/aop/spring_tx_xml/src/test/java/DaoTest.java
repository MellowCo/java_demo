import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IPersonService;

/**
 * @author li
 * @version 1.0
 * @ClassName DaoTest
 * @date 2019/7/14 17:53
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springConfig.xml")
public class DaoTest {
    @Autowired
    private IPersonService services;

    @Test
    public void test(){
        services.getMoney(1,2,100);
    }
}
