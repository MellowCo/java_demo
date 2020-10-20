package com.li.car.dto;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-03-21 20:28
 */
@Data
public class PageDto<T> {
    private Long code;
    private String msg;
    private Long count;
    private List<T> data;
    private Long cur;
}
