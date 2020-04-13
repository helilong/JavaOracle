package com.sec.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库工具类：提供连接和关闭数据的静态方法
 * @author 13947
 *
 */
public class DBUtil {
	//定义私有的静态的常量字符串
	private static final String Driver="oracle.jdbc.driver.OracleDriver";
	private static final String Connect="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String User="scott";
	private static final String Pwd="tiger";
	
	//静态代码块 加载驱动
	static {
		try {
			
			Class.forName(Driver);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//静态方法 获取链接
	public static Connection getconn() {
		Connection conn = null;
		try {
			
			conn=DriverManager.getConnection(Connect, User, Pwd);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//静态方法 关闭连接(普通方法)
	public static void getClose(Connection conn,PreparedStatement ps,ResultSet rs) {
		
			try {
				
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//静态方法 关闭连接
	public static void getClose1(Connection conn,CallableStatement cs,ResultSet rs) {
		
			try {
				
				if(rs!=null) rs.close();
				if(cs!=null) cs.close(); //关闭存储过程
				if(conn!=null) conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
