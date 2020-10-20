package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author li
 * @version 1.0
 * @ClassName JDBCUtils
 * @date 2019/7/10 14:14
 */

public class JDBCUtils {
    private static DataSource ds = null;

    static {
        try {
            //1.导入jar包
            //2.定义配置文件
            //3.加载配置文件
            Properties pt = new Properties();
            pt.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbcConfig.properties"));
            //4.获取数据源
            ds = DruidDataSourceFactory.createDataSource(pt);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){

        return ds;
    }

}
