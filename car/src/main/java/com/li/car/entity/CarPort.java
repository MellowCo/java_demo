package com.li.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 车辆信息
 * @Author: li
 * @Create: 2020-03-21 10:12
 */
@Data
@TableName("carport")
public class CarPort implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String cid;

    private String cimg;
    private String cinfo;
    private String cname;
    private Double crent;
    private Integer status;
}
