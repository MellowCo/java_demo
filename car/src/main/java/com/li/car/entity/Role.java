package com.li.car.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 角色
 * @Author: li
 * @Create: 2020-03-21 10:06
 */
@Data
@TableName("role")
public class Role implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String rid;

    private String roleName;
}
