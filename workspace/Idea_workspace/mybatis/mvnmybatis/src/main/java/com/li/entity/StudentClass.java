package com.li.entity;

import java.util.List;

public class StudentClass {
    private int classId;
    private String classInfo;
    private List<Student> students;

    public StudentClass() {
    }

    public StudentClass(int classId, String classInfo, List<Student> students) {
        this.classId = classId;
        this.classInfo = classInfo;
        this.students = students;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "classId=" + classId +
                ", classInfo='" + classInfo + '\'' +
                ", students=" + students +
                '}';
    }
}
