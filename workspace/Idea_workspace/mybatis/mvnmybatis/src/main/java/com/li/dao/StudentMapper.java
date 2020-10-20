package com.li.dao;

import com.li.entity.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> findAll();

    Student quertStudentByStuno(int stuno);
}
