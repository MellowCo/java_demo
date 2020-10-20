package test;

import cn.li.entity.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Test {
    //增加学生
    public static void addStudent() throws IOException {
        //配置mybatis
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //创建 session
        SqlSession session = factory.openSession();

        String statement = "cn.li.entity.studentMapper.addStudent";
        Student s = new Student(1,"li","23","is");

        session.insert(statement,s);
        //提交
        session.commit();
        System.out.println("增加成功");

        session.close();
    }

    //查询所有学生
    public static void allStudent() throws IOException {
        //配置mybatis
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //创建 session
        SqlSession session = factory.openSession();

        String statement = "cn.li.entity.studentMapper.allStudent";

        List<Student> students = session.selectList(statement);
        //提交
        session.commit();

        System.out.println(students);

        session.close();
    }

    //改学生
    public static void updateStudentBySno() throws IOException {
        //配置mybatis
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //创建 session
        SqlSession session = factory.openSession();

        String statement = "cn.li.entity.studentMapper.updateStudentBySno";
        Student s = new Student(1,"li2","232","is2");

        session.update(statement,s);
        //提交
        session.commit();

        System.out.println("更改成功");

        session.close();
    }

    //删除学生
    public static void delStudentBySno() throws IOException {
        //配置mybatis
        Reader reader = Resources.getResourceAsReader("cig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);

        //创建 session
        SqlSession session = factory.openSession();

        String statement = "cn.li.entity.studentMapper.delStudentBySno";

        session.delete(statement,1);
        //提交
        session.commit();

        System.out.println("删除成功");

        session.close();
    }

    public static void main(String[] args) throws IOException {
        allStudent();
        delStudentBySno();
//        addStudent();
//        updateStudentBySno();
        allStudent();

    }
}
