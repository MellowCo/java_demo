package com.li.mapper;

import com.li.entity.StudentClass;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import javax.annotation.Resource;
import javax.annotation.Resources;

public interface StudentClassMapper {


    @Select("select * from studentclass where classid = #{classid}")
    @Results(id = "StudentClass_map",
            value = {
                @Result(id = true ,column = "classid",property = "classId"),
                @Result(column = "classinfo",property = "classInfo"),
                @Result(column = "classid",property = "studnets",
                        many = @Many(
                                    select = "com.li.mapper.StudentMapper.queryStudentByClassID",
                                    fetchType = FetchType.LAZY
                                )
                        )
            }
    )
    StudentClass queryStudentClassByClassId(int classid);
}
