<%@page import="com.dao.oracle.DBconn.MysqlDB"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>编辑</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<%
	request.setCharacterEncoding("utf-8");
	String EMPno = "";
	EMPno = request.getParameter("EMPNO");
	String sql = "SELECT * FROM EMP where EMPNO='" + EMPno + "'";
	Connection conn = MysqlDB.getConnection();
	Statement stmt = MysqlDB.createStatement(conn);
	ResultSet rs = MysqlDB.executeQuery(stmt, sql);
%>
</head>

<body>

	<center>
		<%
			if (rs.next() == true) {
		%>

		<br> <br>编辑EMP数据信息<br>
		<form name="f1" id="f1" action="servlet/EMPEdit.do" method="post">
			<table border="0">
				<tr>
					<td>编号:</td>
					<td><input type="text" readonly="readonly" name="EMPNO" id="EMPNO"
						value="<%=rs.getString("EMPNO")%>"> 编号不允许编辑</td>
				</tr>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="ENAME" id="ENAME"
						value="<%=rs.getString("ENAME")%>"></td>
				</tr>
				<tr>
					<td>工作:</td>
					<td><input type="text" name="JOB" id="JOB"
						value="<%=rs.getString("JOB")%>"></td>
				</tr>
				<tr>
					<td>领导编号:</td>
					<td><input type="text" name="MGR" id="MGR"
						value="<%=rs.getString("MGR")%>"></td>
				</tr>
				<tr>
					<td>雇佣日期:</td>
					<td><input type="text" name="HIREDATE" id="HIREDATE"
						value="<%=rs.getString("HIREDATE")%>"></td>
				</tr>
				<tr>
					<td>工资:</td>
					<td><input type="text" name="SAL" id="SAL"
						value="<%=rs.getString("SAL")%>"></td>
				</tr>
				<tr>
					<td>奖金:</td>
					<td><input type="text" name="COMM" id="COMM"
						value="<%=rs.getString("COMM")%>"></td>
				</tr>
				<tr>
					<td>部门编号:</td>
					<td><input type="text" name="DEPTNO" id="DEPTNO"
						value="<%=rs.getString("DEPTNO")%>"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value=" 确定 "></td>
				</tr>
			</table>
		</form>
		<%
			} else {
		%>
		<br> <br>编辑EMP数据信息<br> <br> EMP编号为<%=EMPno%>的学生数据在数据库中不存在!<br>
		<br> <a href="StudentList.jsp">返回</a>
		<%
			}
		%>
	</center>
</body>
</html>
