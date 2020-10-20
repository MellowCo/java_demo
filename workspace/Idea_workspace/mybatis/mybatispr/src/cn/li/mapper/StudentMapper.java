package cn.li.mapper;

import cn.li.entity.Student;
import cn.li.entity.StudentBussiness;
import cn.li.entity.StudentClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface StudentMapper {
    //查询所有学生
    List<Student> allStudent();

    //增加学生
    void addStudent(Student student);

    //查询学生总数
    int queryStudentCount();

    List<Map<String,Object>> allStudentByHashMap();

    List<Student> allStudentById();

    List<Student> allStudentByIdHashMap();

    List<Student> queryStudentByAgeOrSex(Student student);

    List<Student> queryStudnetBySnoEq(List<Integer> snos);

    StudentBussiness queryStudentBussiness(int sno);

    Student queryStudentOwithO(int sno);

    StudentClass queryStudentClass(int classId);




}
