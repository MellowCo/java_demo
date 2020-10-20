package com.li.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private int stuNo;
    private String stuName;
    private String stuAge;
    private String studept;
    private String stuSex;
    private int cardId;
    private int classId;

    public Student(int stuNo, String stuName, String stuAge, String studept, String stuSex, int cardId, int classId) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.studept = studept;
        this.stuSex = stuSex;
        this.cardId = cardId;
        this.classId = classId;
    }

    public Student() {
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStudept() {
        return studept;
    }

    public void setStudept(String studept) {
        this.studept = studept;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", studept='" + studept + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", cardId=" + cardId +
                ", classId=" + classId +
                '}';
    }
}
