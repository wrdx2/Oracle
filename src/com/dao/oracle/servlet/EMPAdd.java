package com.dao.oracle.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.oracle.DBconn.MysqlDB;

public class EMPAdd extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public EMPAdd() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取数据
		request.setCharacterEncoding("utf-8");
		String EMPno = "";
		String EName = "";
		String EJob = "";
		String EMgr = "";
		String EHiredate = "";
		String ESal = "";
		String EComm = "";
		String EDeptno = "";
		EMPno = request.getParameter("EMPNO");
		EName = request.getParameter("ENAME");
		EJob = request.getParameter("JOB");
		EMgr = request.getParameter("MGR");
		EHiredate = request.getParameter("HIREDATE");
		ESal = request.getParameter("SAL");
		EComm = request.getParameter("COMM");
		EDeptno = request.getParameter("DEPTNO");

		String sql = "insert into user_20132997.EMP VALUES (";
		sql += EMPno + ",";
		sql += "'" + EName + "',";
		sql += "'" + EJob + "',";
		sql += EMgr + ",";
		sql += "to_date('" + EHiredate + "','yyyy-mm-dd hh24:mi:ss'),";
		sql += ESal + ",";
		sql += EComm + ",";
		sql += EDeptno + ")";
		Connection conn = MysqlDB.getConnection();
		Statement stmt = MysqlDB.createStatement(conn);
		int i = MysqlDB.executeUpdate(stmt, sql);
		
		if (i == 0) {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println("添加失败!");
			out.close();
			return;
		}

		// 跳转
		response.sendRedirect("../EMPList.jsp");

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
