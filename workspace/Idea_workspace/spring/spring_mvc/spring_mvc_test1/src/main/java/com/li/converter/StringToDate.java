package com.li.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Program: spring_mvc_test1
 * @ClassName: StringToDate
 * @Description: 将字符串转换成日期
 * @Author: li
 * @Create: 2019-07-29 15:22
 */
public class StringToDate implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (source == null){
            throw new RuntimeException("输入为空");
        }
        try {
            return format.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("转换错误");
        }

    }
}
