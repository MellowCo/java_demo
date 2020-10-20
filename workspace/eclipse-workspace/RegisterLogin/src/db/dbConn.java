package db;

import java.sql.*;

public class dbConn {
    
    Connection conn=null;
    Statement s=null;
    ResultSet rs=null;
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    String user="root";
    String password="123456";
    
    public ResultSet executeQuery(String sql) {
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
            s=conn.createStatement();
            rs=s.executeQuery(sql);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }
    
    public void free() {
        try {
            if(rs!=null) {
                rs.close();                
            }
            if(s!=null) {
                s.close();                
            }
            if(conn!=null) {
                conn.close();                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

	public int executeUpdate(String sql) {
			int result = 0;
			try {
				Class.forName(driver);
        conn=DriverManager.getConnection(url,user,password);
				Statement s = conn.createStatement();
				result = s.executeUpdate(sql);
			 
			  } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
			return result;
		}


    

}
