package com.li.test;

import com.li.entity.StudentClass;
import com.li.mapper.StudentClassMapper;
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

public class StudentClassTest {
    Reader reader;
    SqlSessionFactory factory;
    SqlSession session;
    StudentClassMapper mapper;


    @Before
    public void before() throws IOException {
        reader = Resources.getResourceAsReader("config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        mapper = session.getMapper(StudentClassMapper.class);
    }

    @After
    public void after() throws IOException {
        session.commit();
        reader.close();
        session.close();
    }

    @Test
    public void queryStudentClassByClassId(){
        StudentClass studentClass = mapper.queryStudentClassByClassId(1);
        System.out.println(studentClass);
    }
}
