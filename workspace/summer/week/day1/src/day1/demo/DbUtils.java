package day1.demo;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbUtils {
    private static String user ;
    private static String pwd;
    private static String url;
    private static String driver;

    private static PreparedStatement ps = null;
    private static Connection conn = null;
    private static ResultSet rs = null;

    static {
        Properties pt = new Properties();

        String path = DbUtils.class.getClassLoader().getResource("db.properties").getPath();

        try {
            pt.load(new FileReader(path));
            user = pt.getProperty("user");
            pwd = pt.getProperty("pwd");
            driver = pt.getProperty("driver");
            url = pt.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getConn() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询
    public static ResultSet getRs(String sql, Object[] obs) {
        getPs(sql, obs);
        try {
            return rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //增 删 改
    public static void update(String sql, Object[] obs) {
        try {
            getPs(sql, obs);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    //预编译statement
 /**
  *功能描述 
  * @author li
  * @date 2019/7/10
  * @param sql
  * @param obs 
  * @return void
  */
    public static void getPs(String sql, Object[] obs) {
        try {
            getConn();
            ps = conn.prepareStatement(sql);

            int i = 1;
            if (obs != null) {
                for (Object ob : obs) {
                    ps.setObject(i++, ob);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
