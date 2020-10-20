package com.li.springboot.datajpa.domain;

import javax.persistence.*;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-08 10:18
 */

@Entity //告诉JPA这是一个实体类(与数据库映射的类)
@Table(name = "tbl_emp") //指定表名(默认为emp)
public class Emp {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "last_name",length = 50)
    //指定列名和长度
    private String lastName;

    @Column
    //默认则为email
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
