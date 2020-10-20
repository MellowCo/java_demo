package Dao;

import Entity.LoginEntity;
import Entity.StudentEntity;

import java.sql.ResultSet;
import java.util.List;

public interface IStudentDao {
    //显示所有学生
    List<StudentEntity> studentAll();


    //根据学号删除学生
    boolean deleteBySno(int sno);

    //根据学号修改学生信息
    boolean changeBySno(int sno, StudentEntity student);


    //学生不存在
    boolean isEmpty(int sno);


    //根据学号显示学生信息
    StudentEntity studentInfoBySno(int sno);

    //增加学生
    boolean addStudent(StudentEntity student);


    //登陆用户名
    boolean login(LoginEntity login);

    //返回查询总数
    int totalCount();

    List<StudentEntity> pageStudent(int page,int pageSize);

    //返回student list
    List<StudentEntity> getStudents(ResultSet rs);

}


