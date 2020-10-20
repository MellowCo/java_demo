package cn.li.convert;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentConvert extends BaseTypeHandler<String> {
    //java->sql
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        if ("男".equals(parameter)) {
            ps.setInt(i, 1);
        } else {
            ps.setInt(i, 0);
        }
    }

    //sql->java
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        return i == 1 ? "男" : "女";
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int i = rs.getInt(columnIndex);
        return i == 1 ? "男" : "女";
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        return i == 1 ? "男" : "女";
    }


}