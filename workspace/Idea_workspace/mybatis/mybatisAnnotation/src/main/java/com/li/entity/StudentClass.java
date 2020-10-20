package com.li.entity;

import java.util.List;

public class StudentClass {
    private int classId;
    private String classInfo;
    private List<Student> studnets;

    public StudentClass() {
    }

    public StudentClass(int classId, String classInfo, List<Student> studnets) {
        this.classId = classId;
        this.classInfo = classInfo;
        this.studnets = studnets;
    }

    @Override
    public String toString() {
        return "StudentClass{" +
                "classId=" + classId +
                ", classInfo='" + classInfo + '\'' +
                ", studnets=" + studnets +
                '}';
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

    public List<Student> getStudnets() {
        return studnets;
    }

    public void setStudnets(List<Student> studnets) {
        this.studnets = studnets;
    }
}
