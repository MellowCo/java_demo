import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class aa {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("springConfig.xml");
        JdbcTemplate tx = ac.getBean("tx", JdbcTemplate.class);

        tx.execute("insert into person values (3,'qian',24)");
    }
}
