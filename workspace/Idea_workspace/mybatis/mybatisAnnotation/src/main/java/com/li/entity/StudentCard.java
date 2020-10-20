package com.li.entity;

import java.io.Serializable;

public class StudentCard implements Serializable {
    private int cId;
    private String cInfo;

    public StudentCard(int cId, String cInfo) {
        this.cId = cId;
        this.cInfo = cInfo;
    }

    public StudentCard() {
    }

    @Override
    public String toString() {
        return "StudentCard{" +
                "cId=" + cId +
                ", cInfo='" + cInfo + '\'' +
                '}';
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }
}
