package com.li.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author li
 * @version 1.0
 * @ClassName JdbcUtils
 * @date 2019/7/16 10:35
 */

public class JdbcUtils {
    private static DataSource ds;

    static{
        Properties pro = new Properties();
        try {
            pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("jdbcConfig.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDs(){
        return ds;
    }
}
