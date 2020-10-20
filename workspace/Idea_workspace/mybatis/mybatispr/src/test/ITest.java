package test;

import cn.li.entity.Student;
import cn.li.entity.StudentBussiness;
import cn.li.entity.StudentClass;
import cn.li.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ITest {
    //查询所有学生
    public static void allStudent() throws IOException {
        //配置mybatis
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //创建 session
        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.allStudent();
        //提交
        session.commit();

        System.out.println(students);

        session.close();
    }

    //增加学生
    public static void addStudent() throws IOException {
        //配置mybatis
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.addStudent(new Student(13,"l3i","141","math","男"));

        session.commit();
        session.close();
    }


    //查询学生总数
    public static void queryStudentCount() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int count = mapper.queryStudentCount();
        session.commit();

        System.out.println(count);
        session.close();

    }

    //根据HashMap查找所有学生
    public static void allStudentByHashMap() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Map<String,Object>> studentMap = mapper.allStudentByHashMap();


        System.out.println(studentMap);
        session.close();


    }

    //根据resultMap关联
    public static void allStudentById() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.allStudentById();

        System.out.println(students);
        session.close();
    }

    //根据resultMap关联
    public static void allStudentByIdHashMap() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.allStudentByIdHashMap();

        System.out.println(students);
        session.close();
    }

    //根据resultMap关联
    public static void queryStudentByAgeOrSex() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student student = new Student();
        // student.setsAge("78");
        student.setsDept("math");

        List<Student> students = mapper.queryStudentByAgeOrSex(student);

        System.out.println(students);
        session.close();
    }


    //根据resultMap关联
    public static void queryStudnetBySnoEq() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Integer> snos = new ArrayList<>();
        snos.add(100);
        snos.add(13);

        List<Student> students = mapper.queryStudnetBySnoEq(snos);

        System.out.println(students);
        session.close();
    }


    public static void queryStudentBussiness() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        StudentBussiness sb = mapper.queryStudentBussiness(2);

        System.out.println(sb);
        session.close();
    }

    public static void queryStudentOwithO() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student sb = mapper.queryStudentOwithO(2);

        System.out.println(sb);
        session.close();
    }

    public static void queryStudentClass() throws IOException {
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        StudentClass sc = mapper.queryStudentClass(1);

        List<Student> students = sc.getStudents();
        System.out.println(students);
        session.close();
    }


    public static void main(String[] args) throws IOException {
        // allStudent();
       // addStudent();
       // allStudent();
       //  queryStudentCount();
       //  allStudentByHashMap();
       //  allStudentById();
       //  allStudentByIdHashMap();
       //  queryStudentByAgeOrSex();
       //  queryStudnetBySnoEq();
       //  queryStudentBussiness();
       //  queryStudentOwithO();
        queryStudentClass();
    }




}
