<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<%@ include file="check.jsp" %>
<body>
<form action="changePasswd.jsp" method="post">
<table width="387" border="1" cellpadding="2" cellspacing="0" bordercolor="#FF0000" bordercolorlight="#FF0000" bordercolordark="#FFFFFF">
  <tr>
    <td width="112" bgcolor="#CCFF66"><font size="5" face="隶书">新密码:</font></td>
    <td width="261"><font size="5">
      <input type="password" name="password1" style=width:165pt; maxlength="50">
    </font></td>
  </tr>
  <tr>
    <td bgcolor="#CCFF66"><font size="5" face="隶书">密码确认:</font></td>
    <td><font size="5">
      <input type="password" name="password2" style=width:165pt; maxlength="50">
    </font></td>
  </tr>
  <tr>
    <td colspan="2" ><div align="center">
        <input type="submit" name="Submit" value="提交"> 
    </div></td>
  </tr>  
</table>
</form>

</body>
</html>
