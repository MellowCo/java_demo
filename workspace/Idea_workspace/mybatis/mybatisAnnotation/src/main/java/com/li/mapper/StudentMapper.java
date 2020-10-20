package com.li.mapper;

import com.li.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

// @CacheNamespace(blocking = true)
public interface StudentMapper {
    @Select("select * from student")
    @Results(
            id = "studnet_map",
            value = {
                    @Result(id = true,column = "stuno",property = "stuNo"),
                    @Result(column = "stuname" , property = "stuName"),
                    @Result(column = "stuage" , property = "stuAge"),
                    @Result(column = "studept" , property = "studept"),
                    @Result(column = "stusex" , property = "stuSex"),
                    @Result(column = "classid" , property = "classId"),
                    @Result(column = "cardid" , property = "cardId"),
                    @Result(column = "classid" , property = "studentCard",
                            one = @One(select = "com.li.mapper.StudentCardMapper.queryStudentCardByCardId",
                                        fetchType = FetchType.LAZY
                            )
                    ),
            }
    )
    List<Student> queryAllStudent();

    @Insert("insert into student values(#{stuNo},#{stuName},#{stuAge},#{studept},#{stuSex},#{cardId},#{classId})")
    void addStudent(Student student);

    @Update("update student set stuage = #{stuAge}, stuname = #{stuName} where stuno = #{stuNo}")
    void updateStudentByStuNo(Student student);

    @Select("select * from student where stuno = #{stuno}")
    Student queryStudentBySno(int stuno);

    @Select("select * from student where classid = #{clasid}")
    Student queryStudentByClassID(int classid);

    @Delete("delete from student where stuno = #{stuno}")
    void deleteStudent(int stuno);


}
