package day1.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    static ResultSet rs = null;

    //增加学生
    public void addStudent(Student student) {
        String sql = "insert into person values(?,?,?,?)";
        Object[] obs = {student.getId(), student.getName(), student.getSex(),student.getAge()};

        DbUtils.update(sql, obs);
    }

    //根据学号查找学生
    public Student queryStudentById(int id) {
        String sql = "select * from person where id = ?";
        Object[] obs = {id};

        rs = DbUtils.getRs(sql, obs);

        try {
            if (rs.next()) {
                return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("sex"), rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeRs(rs);
            DbUtils.close();
        }
        return null;
    }

    //查找所有学生
    public List<Student> queryStudents() {
        String sql = "select * from person";
        rs = DbUtils.getRs(sql, null);
        List<Student> students = new ArrayList<>();

        try {
            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("sex"), rs.getInt("age")));
            }
            return students;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeRs(rs);
            DbUtils.close();
        }
        return null;
    }

    //更改学生
    public void updateStudentById(Student student) {
        String sql = "update person set name = ? ,sex = ? ,age =? where id = ?";
        Object[] obs = {student.getName(), student.getSex(), student.getAge(), student.getId()};

        DbUtils.update(sql, obs);
    }

    //删除学生
    public void deleteStudentById(int id) {
        String sql = "delete  from person where id = ?";
        Object[] obs = {id};

        DbUtils.update(sql, obs);
    }

    //关闭连接
    public void closeRs(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
