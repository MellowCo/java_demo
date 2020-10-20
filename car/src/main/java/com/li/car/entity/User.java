package com.li.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 10:03
 */
@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String uid;
    private String email;
    private String userName;
    private String pwd;
    private String sex;
    private String tel;
    private String address;
    private Integer status;
    @TableField
    private Date createDate;
    private String rid;
}
