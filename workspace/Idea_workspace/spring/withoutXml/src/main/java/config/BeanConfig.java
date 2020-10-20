package config;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.li")
@Import(JdbcConfig.class)
@PropertySource("classpath:config/Jdbc.properties")
public class BeanConfig {

}
