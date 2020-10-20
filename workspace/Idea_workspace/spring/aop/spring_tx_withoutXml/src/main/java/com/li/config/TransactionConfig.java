package com.li.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author li
 * @version 1.0
 * @ClassName TransactionConfig
 * @date 2019/7/16 20:53
 */

public class TransactionConfig {
    @Bean(name = "transaction")
    DataSourceTransactionManager creaTransction(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
