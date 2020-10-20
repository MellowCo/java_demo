package com.li.test;

import com.li.dao.StudentClassMapper;
import com.li.dao.StudentMapper;
import com.li.entity.Student;
import com.li.entity.StudentClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {

    public static void findAll() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> all = mapper.findAll();

        System.out.println(all);
        session.close();
    }

    public static void queryClassByClassId() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();

        StudentClassMapper mapper = session.getMapper(StudentClassMapper.class);
        StudentClass aClass = mapper.queryClassByClassId(1);

        System.out.println(aClass.getClassId() + "--" + aClass.getClassInfo());
        System.out.println(aClass.getStudents());
        session.close();
    }

    //测试一级缓存
    public static void quertStudentByStuno() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        StudentMapper mapper2 = session.getMapper(StudentMapper.class);

        Student student = mapper.quertStudentByStuno(1);
        Student student2 = mapper2.quertStudentByStuno(1);

        System.out.println(student);
        System.out.println(student2);

        session.close();
    }

    //测试二级缓存
    public static void quertStudentByStuno2() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        SqlSession session2 = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        StudentMapper mapper2 = session2.getMapper(StudentMapper.class);

        Student student = mapper.quertStudentByStuno(1);
        session.close();

        Student student2 = mapper2.quertStudentByStuno(1);

        System.out.println(student);
        System.out.println(student2);

        session2.close();
    }



    public static void main(String[] args) throws IOException {
        // findAll();
        // queryClassByClassId();
        quertStudentByStuno2();
    }
}
