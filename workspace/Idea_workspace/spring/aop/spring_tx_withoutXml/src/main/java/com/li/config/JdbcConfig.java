package com.li.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author li
 * @version 1.0
 * @ClassName JdbcConfig
 * @date 2019/7/16 20:39
 */
public class JdbcConfig {
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${pwd}")
    private String pwd;

    @Bean(name = "dataSource")
    DataSource creaDs(){
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setUser(user);
            ds.setJdbcUrl(url);
            ds.setDriverClass(driver);
            ds.setPassword(pwd);
            return ds;
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean(name = "template")
    JdbcTemplate creaTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
