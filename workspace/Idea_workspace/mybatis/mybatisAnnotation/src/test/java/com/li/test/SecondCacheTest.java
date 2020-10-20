package com.li.test;

import com.li.entity.Student;
import com.li.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

public class SecondCacheTest {
    Reader reader;
    SqlSessionFactory factory;




    @Before
    public void before() throws IOException {
        reader = Resources.getResourceAsReader("config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);


    }

    @After
    public void after() throws IOException {
        reader.close();
    }

    @Test
    public void secondCache(){
        SqlSession session1 = factory.openSession();
        SqlSession  session = factory.openSession();

        StudentMapper mapper1 = session1.getMapper(StudentMapper.class);
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student1 = mapper1.queryStudentBySno(1);
        session1.close();

        Student student = mapper.queryStudentBySno(1);
        session.close();

        System.out.println(student);
        System.out.println(student1);
        System.out.println(student == student1);
    }

}
