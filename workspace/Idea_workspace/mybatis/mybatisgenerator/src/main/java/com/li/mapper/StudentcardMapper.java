package com.li.mapper;

import com.li.entity.Studentcard;
import com.li.entity.StudentcardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentcardMapper {
    long countByExample(StudentcardExample example);

    int deleteByExample(StudentcardExample example);

    int deleteByPrimaryKey(Integer cardid);

    int insert(Studentcard record);

    int insertSelective(Studentcard record);

    List<Studentcard> selectByExample(StudentcardExample example);

    Studentcard selectByPrimaryKey(Integer cardid);

    int updateByExampleSelective(@Param("record") Studentcard record, @Param("example") StudentcardExample example);

    int updateByExample(@Param("record") Studentcard record, @Param("example") StudentcardExample example);

    int updateByPrimaryKeySelective(Studentcard record);

    int updateByPrimaryKey(Studentcard record);
}