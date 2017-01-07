<%@page import="com.dao.oracle.DBconn.MysqlDB"%>
<%@page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String sql = "select * from EMP";
	MysqlDB db = new MysqlDB();
	Connection conn = db.getConnection();
	Statement stmt = db.createStatement(conn);
	ResultSet rs = db.executeQuery(stmt, sql);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>EMP数据信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>    
        EMP信息列表
    <br>
    <br>
    <a href="EMPAdd.html">添加</a>
    <br>
    <br>
    
    <table border="1" cellspacing="0" cellpadding="4">
    <tr>
    <th>编号</th>
    <th>姓名</th>
    <th>工作</th>
    <th>领导编号</th>
    <th>雇佣日期</th>
    <th>工资</th>
    <th>奖金</th>
    <th>部门编号</th>
    <th>操作</th>
    </tr>
    <%while (rs.next()) { %>
    <tr>
    <td><%=rs.getString("EMPNO") %></td>
    <td><%=rs.getString("ENAME") %></td>
    <td><%=rs.getString("JOB") %></td>
    <td><%=rs.getString("MGR") %></td>
    <td><%=rs.getString("HIREDATE") %></td>
    <td><%=rs.getString("SAL") %></td>
    <td><%=rs.getString("COMM") %></td>
    <td><%=rs.getString("DEPTNO") %></td>
    <td>
    	<a href="EMPEdit.jsp?EMPNO=<%=rs.getString("EMPNO") %>" >编辑</a> 
    	<a href="servlet/EMPDelete.do?EMPNO=<%=rs.getString("EMPNO") %>" >删除</a> </td>
    </tr>
    <% } %>
    </table>
    <br>
    
    <br>
    <a href="index.jsp">返回</a>
    </center>
  </body>
</html>
