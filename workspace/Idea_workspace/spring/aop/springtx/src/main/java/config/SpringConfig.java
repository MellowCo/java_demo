package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("dao")
public class SpringConfig {

    @Bean(name = "dataSource")
    public DriverManagerDataSource createSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setPassword("li1234");
        source.setUsername("root");
        source.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        return source;
    }

    @Bean(name = "tx")
    public JdbcTemplate createTemplate(DriverManagerDataSource source){
        return new JdbcTemplate(source);
    }
}
