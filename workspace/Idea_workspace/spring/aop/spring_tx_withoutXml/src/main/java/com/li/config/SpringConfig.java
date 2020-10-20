package com.li.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author li
 * @version 1.0
 * @ClassName SpringConfig
 * @date 2019/7/16 20:12
 */
@Configuration
@ComponentScan("com.li")
@Import({JdbcConfig.class,TransactionConfig.class})
@EnableTransactionManagement
@PropertySource("jdbcConfig.properties")
public class SpringConfig {
}
