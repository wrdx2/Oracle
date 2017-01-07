package com.dao.oracle.DBconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author wrd
 * @version 1.0
 * @date 20107-1-4
 * 
 */
public class MysqlDB {

	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
		String UserName = "user_20132997";// 数据库用户登陆名 ( 也有说是 schema 名字的 )
		String Password = "123456";// 密码
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");//加入oracle的驱动，“”里面是驱动的路径
			conn = DriverManager.getConnection(url, UserName, Password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 
	 * @param conn
	 * @return
	 */
	public static Statement createStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	/**
	 * 
	 * @param stmt
	 * @param sql
	 * @return rs
	 */
	public static ResultSet executeQuery(Statement stmt, String sql) {
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 
	 * @param stmt
	 * @param sql
	 * @return ret
	 */
	public static int executeUpdate(Statement stmt, String sql) {
		int ret = 0;
		try {
			ret = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	/**
	 * @param conn
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	/**
	 * @param stmt
	 */
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
	}

	/**
	 * @param rs
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
	
}
