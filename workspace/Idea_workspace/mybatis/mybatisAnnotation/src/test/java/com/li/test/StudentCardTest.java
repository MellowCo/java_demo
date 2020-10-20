package com.li.test;

import com.li.entity.StudentCard;
import com.li.mapper.StudentCardMapper;
import com.li.mapper.StudentClassMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StudentCardTest {
    Reader reader;
    SqlSessionFactory factory;
    SqlSession session;
    StudentCardMapper mapper;


    @Before
    public void before() throws IOException {
        reader = Resources.getResourceAsReader("config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        mapper = session.getMapper(StudentCardMapper .class);
    }

    @After
    public void after() throws IOException {
        session.commit();
        reader.close();
        session.close();
    }

    @Test
    public void queryStudentCards(){
        List<StudentCard> studentCards = mapper.queryStudentCardsByCardId();
        System.out.println(studentCards);
    }
}
