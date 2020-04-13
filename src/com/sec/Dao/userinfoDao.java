package com.sec.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sec.model.userinfo;
import com.sec.util.DBUtil;

/**
 * 提供针对表的增删改查操作的方法
 * @author 13947
 *
 */
public class userinfoDao {
	
	//普通查询
	public ArrayList<userinfo> query(){
		//创建对象
		Connection conn =DBUtil.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<userinfo> list=new ArrayList<userinfo>();
		//构造sql语句
		String sql="select * from userinfo";
		try {
			
			//创建预编译对象
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//从结果集中取出数据并封装到实体集中
				userinfo user=new userinfo(rs.getInt("id"), rs.getString("name"));
				//将实体类对象添加到集合中
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.getClose(conn, ps, rs);
		}
		return list;
	}
	
	/**
	 * 存储过程 实现查询
	 * @return
	 */
	public ArrayList<userinfo> query1(){
		//创建对象
		Connection conn=DBUtil.getconn();
		CallableStatement cs=null;
		ResultSet rs=null;
		ArrayList<userinfo> list=new ArrayList<userinfo>();
		
		//构造sql语句
		String sql="{call pro_select(?)}";
		
		try {
			//创建预编译对象
			cs=conn.prepareCall(sql);
			
			//注册输出参数类型
			cs.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
			
			//执行
			cs.execute();
			
			//获取数据参数的值
			rs=(ResultSet)cs.getObject(1);
			
			while(rs.next()) {
				//从结果集中取出数据并封装到实体集中
				userinfo user=new userinfo(rs.getInt("id"), rs.getString("name"));
				//将实体类对象添加到集合中
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//关闭连接
			DBUtil.getClose1(conn, cs, rs);
		}
		return list;
		
	}
	
	public int insert(userinfo user) {
		//创建对象
		Connection conn=DBUtil.getconn();
		CallableStatement cs=null;
		int i=0;
		String sql="call pro_insert(?,?)";
		try {
			
			cs=conn.prepareCall(sql);
			
			cs.setInt(1, user.getId());
			cs.setString(2, user.getName());
			
			i=cs.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.getClose1(conn, cs, null);
		}
		return i;
	}
}
