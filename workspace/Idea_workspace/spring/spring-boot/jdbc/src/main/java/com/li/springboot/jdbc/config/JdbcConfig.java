package com.li.springboot.jdbc.config;

/**
 * @Description:
 * @Author: li
 * @Create: 2019-09-06 18:33
 */
// @Configuration
public class JdbcConfig {

    /*
     * 配置druid数据源
     */
    // @Bean
    // @ConfigurationProperties("spring.datasource.druid")
    // public DataSource driud(){
    //     return new DruidDataSource();
    // }

    //配置Druid的监控
    //1、配置一个管理后台的Servlet
    /*
     *

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new StatViewServlet());
        //配置访问路径
        bean.setUrlMappings(Arrays.asList("/druid/*"));

        Map<String, String> initParams = new HashMap<>();
        //设置监控的用户名和明码
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        //IP白名单,默认就是允许所有访问
        initParams.put("allow","");
        //IP黑名单 (存在共同时，deny优先于allow)
        initParams.put("deny","192.168.15.21");
        bean.setInitParameters(initParams);

        return bean;
    }

    * */
     /*
      *


    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        //拦截所有请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        //放行静态资源
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");

        bean.setInitParameters(initParams);

        return bean;

    }

    * */


}
