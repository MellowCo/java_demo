import demo1.entity.Student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName JdbcTest
 * @date 2019/7/10 14:48
 */

public class JdbcTest {
    @Test
    public void query() {
        //查询所有学生
        JdbcTemplate tx = new JdbcTemplate(JDBCUtils.getDataSource());
        List<Student> students = tx.query("select * from person where id = ?", new BeanPropertyRowMapper<Student>(Student.class),1);
        System.out.println(students);
    }

    @Test
    public void update() {
        //增加一个学生
        JdbcTemplate tx = new JdbcTemplate(JDBCUtils.getDataSource());
        int i = tx.update("insert into person values(?,?,?,?)", 6, "小明", "男", 35);
        System.out.println(i);
    }
}
