package Utils;

import java.sql.*;

public class DBUtils {
    private static Connection conn = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static String Driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&useSSL=false";
    private static String root = "root";
    private static String pwd = "li1234";

    //返回PrepareStatement
    public static PreparedStatement getPrepareStatement(String sql, Object[] objects) {
        conn = getConnection();
        if (conn != null) {
            try {
                ps = conn.prepareStatement(sql);
                if (objects != null) {
                    for (int i = 0; i < objects.length; i++) {
                        ps.setObject(i + 1, objects[i]);
                    }
                }
                return ps;
            } catch (SQLException e1) {
                e1.printStackTrace();
                return null;
            }
        }
        return null;
    }

    //增删改
    public static boolean executeUpdates(String sql, Object[] objects) {
        try {
            ps = getPrepareStatement(sql, objects);
            if (ps != null) {
                int i = ps.executeUpdate();
                return i > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            free();
        }
    }

    //查
    public static ResultSet executeQuerys(String sql, Object[] objects) {
        ps = getPrepareStatement(sql, objects);
        if (ps != null) {
            try {
                return ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Connection getConnection() {
        try {
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, root, pwd);
            if (conn != null) {
                return conn;
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void free() {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void frees(AutoCloseable... autoCloseables) {
        try {
            for (AutoCloseable closeable : autoCloseables) {
                closeable.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回查询总数
    public static int getCount(String sql) {
        ps = getPrepareStatement(sql, null);
        if (ps == null) {
            return -1;
        }
        try {
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}


