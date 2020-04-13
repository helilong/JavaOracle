package com.sec.Oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Oracleconnect {
	public static void main(String[] args) {
		try {
			//��������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��ȡ���Ӷ���
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			//sql
			String sql="select * from userinfo";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			//���������
			while(rs.next()) {
				System.out.println(rs.getInt("id")+"------"+rs.getString("name"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
