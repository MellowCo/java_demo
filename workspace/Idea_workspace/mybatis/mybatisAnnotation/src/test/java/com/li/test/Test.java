package com.li.test;

import com.li.entity.Student;
import com.li.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    Reader reader;
    SqlSessionFactory factory;
    SqlSession session;
    StudentMapper mapper;


    @Before
    public void before() throws IOException {
        reader = Resources.getResourceAsReader("config.xml");
        factory = new SqlSessionFactoryBuilder().build(reader);
        session = factory.openSession();
        mapper = session.getMapper(StudentMapper.class);
    }

    @After
    public void after() throws IOException {
        session.commit();
        reader.close();
        session.close();
    }

    @org.junit.Test
    public void findAllStudnet() {
        List<Student> students = mapper.queryAllStudent();
        System.out.println(students);
    }

    @org.junit.Test
    public void insertStudnet() {
        Student student = new Student(100, "li", "12", "is", "nan", 1, 2);
        mapper.addStudent(student);
        findAllStudnet();
    }

    @org.junit.Test
    public void updateStudnet(){
        Student student = new Student();
        student.setStuAge("100");
        student.setStuNo(100);
        student.setStuName("test");

        mapper.updateStudentByStuNo(student);

        findAllStudnet();
    }

    @org.junit.Test
    public void  queryStudentByStuNo(){
        Student student = mapper.queryStudentBySno(1);
        System.out.println(student);
    }

    @org.junit.Test
    public void  queryAllStudent(){
        List<Student> students = mapper.queryAllStudent();
        for (Student student : students) {
            System.out.println(student.getStudentCard());
        }
    }

    @org.junit.Test
    public void deleteStudent(){
        mapper.deleteStudent(100);

    }
}
