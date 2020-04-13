package com.sec.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ���ݿ⹤���ࣺ�ṩ���Ӻ͹ر����ݵľ�̬����
 * @author 13947
 *
 */
public class DBUtil {
	//����˽�еľ�̬�ĳ����ַ���
	private static final String Driver="oracle.jdbc.driver.OracleDriver";
	private static final String Connect="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String User="scott";
	private static final String Pwd="tiger";
	
	//��̬����� ��������
	static {
		try {
			
			Class.forName(Driver);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//��̬���� ��ȡ����
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
	
	//��̬���� �ر�����(��ͨ����)
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
	
	//��̬���� �ر�����
	public static void getClose1(Connection conn,CallableStatement cs,ResultSet rs) {
		
			try {
				
				if(rs!=null) rs.close();
				if(cs!=null) cs.close(); //�رմ洢����
				if(conn!=null) conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
