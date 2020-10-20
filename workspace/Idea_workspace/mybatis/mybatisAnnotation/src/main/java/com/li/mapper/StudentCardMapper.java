package com.li.mapper;

import com.li.entity.StudentCard;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCardMapper {
    @Select("select * from studentcard where cardid = #{cardid}")
    @Results(
            id = "studentCard_map",
            value = {
                @Result(id = true,column = "cardid",property = "cId"),
                @Result(column = "cardinfo",property = "cInfo")
            }
    )
    StudentCard queryStudentCardByCardId(int cardId);

    @Select("select * from studentcard")
    @ResultMap("studentCard_map")
    List<StudentCard> queryStudentCardsByCardId();
}
