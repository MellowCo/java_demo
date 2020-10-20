package demo1;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import demo1.entity.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author li
 * @version 1.0
 * @ClassName Pool
 * @date 2019/7/10 10:27
 */

public class Pool {
    public static void main(String[] args) {
        DataSource source = new ComboPooledDataSource();

        JdbcTemplate tx = new JdbcTemplate(source);
        // tx.update("update person set name =? where id = ?", "lid", 3);

        List<Student> students = tx.query("select * from person",new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println(students);
    }
}
