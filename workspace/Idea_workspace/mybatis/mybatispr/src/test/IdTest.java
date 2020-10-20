package test;

import cn.li.entity.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class IdTest {
    public static void main(String[] args) throws IOException {
        //加载Mybatis配置文件，建立数据库连接
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factor = new SqlSessionFactoryBuilder().build(reader);

        //与数据库建立连接， session->connection
        SqlSession session = factor.openSession();
        String statement = "cn.li.entity.personMapper.queryPersonById";
        Person person = session.selectOne(statement, 1);

        System.out.println(person);
        //关闭
        session.close();
    }


}
