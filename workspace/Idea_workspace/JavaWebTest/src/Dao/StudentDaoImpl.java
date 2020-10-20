package Dao;

import Entity.LoginEntity;
import Entity.StudentEntity;
import Utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements IStudentDao {

    public List<StudentEntity> getStudents(ResultSet rs) {
        List<StudentEntity> students = new ArrayList<>();
        try {
            if (rs == null) {
                return null;
            }
            while (rs.next()) {
                StudentEntity student = new StudentEntity(rs.getInt("sno"), rs.getString("sname"), rs.getString("sage"), rs.getString("sdept"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtils.free();
        }
    }

    //显示所有学生
    public List<StudentEntity> studentAll() {
        String sql = "select * from student";
        ResultSet rs = DBUtils.executeQuerys(sql, null);
        return getStudents(rs);
    }


    //根据学号删除学生
    public boolean deleteBySno(int sno) {
        String sql = "delete from student where sno=?";
        Object[] objects = {sno};
        return DBUtils.executeUpdates(sql, objects);
    }

    //根据学号修改学生信息
    public boolean changeBySno(int sno, StudentEntity student) {

        String sql = "update student set sname=?,sage=?,sdept=? where sno=?";
        Object[] objects = {student.getSname(), student.getSage(), student.getSdept(), sno};
        return DBUtils.executeUpdates(sql, objects);
    }


    //学生不存在
    public boolean isEmpty(int sno) {
        return studentInfoBySno(sno) == null;
    }


    //根据学号显示学生信息
    public StudentEntity studentInfoBySno(int sno) {
        String sql = "select * from student where sno=?";
        Object[] objects = {sno};

        StudentEntity student = null;
        ResultSet rs = null;
        try {
            rs = DBUtils.executeQuerys(sql, objects);
            if (rs == null) {
                return null;
            }
            if (rs.next()) {
                student = new StudentEntity(rs.getInt("sno"), rs.getString("sname"), rs.getString("sage"), rs.getString("sdept"));
                return student;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtils.free();
        }
    }

    //增加学生
    public boolean addStudent(StudentEntity student) {

        String sql = "insert into student values(?,?,?,?)";
        Object[] objects = {student.getSno(), student.getSname(), student.getSage(), student.getSdept()};
        return DBUtils.executeUpdates(sql, objects);
    }


    //登陆用户名
    public boolean login(LoginEntity login) {
        String sql = "select * from client where name =? and password =?";
        Object[] objects = {login.getName(), login.getPassword()};
        ResultSet rs = DBUtils.executeQuerys(sql, objects);
        if (rs != null) {
            try {
                return rs.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public int totalCount() {
        String sql = "select count(1) from student";
        return DBUtils.getCount(sql);
    }

    public List<StudentEntity> pageStudent(int page, int pageSize) {
        String sql = "select * from student limit ?,?";
        Object[] objects = {page * pageSize, pageSize};
        ResultSet rs = DBUtils.executeQuerys(sql, objects);
        return getStudents(rs);
    }


}