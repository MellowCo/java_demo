<%@page contentType="text/html;charset=gb2312"%>
<%@page import="java.sql.*"%>
<HTML>
<style type="text/css">
<!--
.style1 {
	font-size: xx-large;
	font-weight: bold;
}
-->
</style>
<BODY>
<p align="center" class="style1">JDBC测试调试页面<font size="1">（V2版）</font></p>
<p>
  <%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
int columnnum;

request.setCharacterEncoding("GBK");
String jdbcDriver = request.getParameter("jdbcDriver");
String connectionString = request.getParameter("connectionString");
String sqlStr = request.getParameter("sqlStr");
if( jdbcDriver == null) jdbcDriver = "";
if( connectionString == null) connectionString = "";
if( sqlStr == null) sqlStr = "";

if(!jdbcDriver.equals("") && !connectionString.equals("")  && !sqlStr.equals(""))
{
	try{
		Class.forName(jdbcDriver);
	}
	catch(ClassNotFoundException ce){
		out.println(ce.getMessage());
	}
	try{
		conn=DriverManager.getConnection(connectionString);
			stmt=conn.createStatement(
		ResultSet.TYPE_SCROLL_INSENSITIVE,
		ResultSet.CONCUR_READ_ONLY);
			rs=stmt.executeQuery(sqlStr);
			ResultSetMetaData rsmd=rs.getMetaData();
			columnnum=rsmd.getColumnCount();
			
			out.print("<TABLE BORDER='1'>");
			do
			{
				out.print("<TR>");
				for(int i=1;i<=columnnum;i++)
				{
					if (rs.getRow()==0)
					{
						out.print("<TD>"+rsmd.getColumnName(i)+"</TD>");
						
					}
					else
					{
						if(rs.getObject(i)!=null)
							out.print("<TD>"+rs.getObject(i).toString()+"</TD>");
						else
							out.print("<TD>&nbsp;</TD>");
					}
				}
				out.print("</TR>");	
			}while(rs.next());
				
			out.print("</TABLE>");
	}
	catch(SQLException e){
		out.println(e.getMessage());
	}
	finally{
		stmt.close();
		conn.close();
	}
}
%>
</p>
<FORM Action="" Method=POST>
<font color="#0000FF">JDBC驱动程序：</font><br>
Class.forName(&quot;<input name="jdbcDriver" type="text" Value="<%=jdbcDriver%>" size="50"> &quot;)<br><br>  
<font color="#0000FF">相应JDBC驱动程序的连接串：</font><br>
DriverManager.getConnection(&quot;<input name="connectionString" type="text" Value="<%=connectionString%>" size="50">&quot;)
<br><br>  
<font color="#0000FF">SQL语句：</font>
<input name="sqlStr" type="text" size="50" Value="<%=sqlStr%>"> 
(注：SQL语句中符号都必须用英文，字符串用单引号）
<P>
<INPUT Type=Submit Value=" 执行">
</FORM>
<p><strong><font size="+2">使用示范：</font></strong></p>
<p>示例一（连接同一服务器上的ODBC数据源）：<br>
  Class.forName(&quot;sun.jdbc.odbc.JdbcOdbcDriver&quot;)<br>
  DriverManager.getConnection(&quot;jdbc:odbc:grade&quot;)<br>
SQL语句：select * from grade
</p>
<p>示例二（用JDBC连接另一服务器上MySQL数据库）：<br>
  Class.forName(&quot;com.mysql.jdbc.Driver&quot;)<br>
  DriverManager.getConnection(&quot;jdbc:mysql://localhost:3306/test?user=root&amp;password=jf12345&quot;); <br>
  SQL语句：select * from users</p>
<p>示例二（用JDBC连接另一服务器上SQL Server数据库）：<br>
Class.forName(&quot;com.microsoft.jdbc.sqlserver.SQLServerDriver&quot;)<br>
DriverManager.getConnection(&quot;jdbc:microsoft:sqlserver://localhost:1433;user=sa;password=123456;DatabaseName=pubs&quot;); <br>
SQL语句：select * from jobs</p>
</BODY></HTML>
