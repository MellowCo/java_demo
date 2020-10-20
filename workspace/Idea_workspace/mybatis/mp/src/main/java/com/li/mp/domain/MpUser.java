package com.li.mp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-02-19 20:50
 */
@Data
@TableName("mp_user")
public class MpUser extends Model<MpUser> {
    @TableId
    private Long id;
    @TableField("name")
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private Long createTime;
}
