package day1;

import java.sql.*;

public class SqlTest {
    static String user = "root";
    static String pwd = "li1234";
    static String url = "jdbc:mysql://localhost:3306/test?useSSL=false&characterEncoding=UTF-8";
    static PreparedStatement ps = null;
    static Connection conn = null;
    static ResultSet rs = null;

    //查询数据库
    public static void query() {
        try {
            //1.导入jar包
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获得数据库连接对象
            conn = DriverManager.getConnection(url, user, pwd);
            //4.定义sql语句
            String sql = "select * from person";
            //5.获取sql执行对象
            ps = conn.prepareStatement(sql);
            //6.执行sql语句
            rs = ps.executeQuery();
            //7.处理结果，循环打印信息
            while (rs.next()) {
                System.out.print(rs.getInt("id") + ",");
                System.out.print(rs.getString("name") + ",");
                System.out.println(rs.getInt("age"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //8.释放资源
            close(rs, ps, conn);
        }
    }

    //更新数据
    public static void update() {
        try {
            //1.导入jar包
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获得数据库连接对象
            conn = DriverManager.getConnection(url, user, pwd);
            //4.定义sql语句
            //5.获取sql执行对象
            ps = conn.prepareStatement("insert into person values (?,?,?,?)");
            //6.预编译的SQL语句,注入占位符
            ps.setInt(1, 5);
            ps.setString(2, "小明");
            ps.setString(3, "男");
            ps.setInt(4, 15);
            //7.执行sql语句
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //8.释放资源
            close(rs, ps, conn);
        }
    }

    //删除
    public static void delete() {
        try {
            //1.导入jar包
            //2.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //3.获得数据库连接对象
            conn = DriverManager.getConnection(url, user, pwd);
            //4.定义sql语句
            //5.获取sql执行对象
            ps = conn.prepareStatement("delete from person where id = ?");
            //6.预编译的SQL语句,注入占位符
            ps.setInt(1, 5);
            //7.执行sql语句
            ps.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //8.释放资源
            close(rs, ps, conn);
        }
    }

    //关闭连接
    public static void close(ResultSet rs, PreparedStatement ps, Connection conn) {
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


    public static void main(String[] args) {
        query();
        update();
        System.out.println("--------添加后---------");
        query();
        delete();
        System.out.println("--------删除后---------");
        query();
    }

}
