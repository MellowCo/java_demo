package com.li.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 订单
 * @Author: li
 * @Create: 2020-03-21 10:07
 */
@Data
@TableName("corder")
public class Corder implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String oid;

    private String cid;
    private String uid;
    private String cname;
    private Double crent;
    private String takeTime;
    private String getTime;
    private Integer status;
}
