package com.sec.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sec.model.userinfo;
import com.sec.util.DBUtil;
import com.sec.util.pageModel;

/**
 * 分页查询
 * @author 13947
 *
 */
public class userinfolimit {

	/**
	 * 分页
	 * @param PageNo
	 * @return
	 */
	
	public pageModel<userinfo> getAllUserinfo(int PageNo){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		pageModel<userinfo> pm=null;
		ArrayList<userinfo> list= new ArrayList<userinfo>();
		conn=DBUtil.getconn();
		try {
			
			pstmt=conn.prepareStatement("select id,name from (select rownum rn,u.* from userinfo u where rownum<=?* ?) n where n.rn>(?-1)*?");
			
			pstmt.setInt(1, PageNo);
			pstmt.setInt(2, 5);
			pstmt.setInt(3, PageNo);
			pstmt.setInt(4, 5);
			rs=pstmt.executeQuery();
			userinfo info=null;
			while(rs.next()){
				info=new userinfo();
				info.setId(rs.getInt("id"));
				info.setName(rs.getString("name"));
				list.add(info);
			}
			
			pm=new pageModel<userinfo>(5);//带一个参数的构造方法
			pm.setList(list);//list集合里面的数据 给工具类的属性
			pm.setCurrentPage(PageNo);//设置当前页
			pm.setSumCount(getCount(conn, pstmt, rs));//调用获取总记录数的方法得到总记录数
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.getClose(conn, pstmt, rs);
		}
		return pm;
		
	}
	
	//获取总记录数
	
	private int getCount(Connection conn,PreparedStatement pstmt,ResultSet rs){
		String sql="select count(*)  from userinfo";
		int count=0;
		try {
			pstmt=conn.prepareCall(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
	}
	
	/**
	 * 使用存储过程 分页
	 */
	public pageModel<userinfo> getAllUserinfo1(int PageNo){
		Connection conn=null;
		CallableStatement cs=null;
		ResultSet rs= null;
		pageModel<userinfo> pm=null;
		ArrayList<userinfo> list= new ArrayList<userinfo>();
		conn=DBUtil.getconn();
		try {
			String sql="call pro_query_page(?,?,?,?,?)";
			cs=conn.prepareCall(sql);
			
			cs.setString(1, "userinfo");
			cs.setInt(2, PageNo);
			cs.setInt(3, 5);
			//注册输出参数类型
			cs.registerOutParameter(4, oracle.jdbc.OracleTypes.NUMBER);
			cs.registerOutParameter(5,oracle.jdbc.OracleTypes.CURSOR);
			//执行
			cs.execute();
			int sumcount=cs.getInt(4);
			rs=(ResultSet) cs.getObject(5);
			userinfo info=null;
			while(rs.next()){
				info=new userinfo();
				info.setId(rs.getInt("id"));
				System.out.println(rs.getInt("id"));
				info.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
				list.add(info);
			}
			
			pm=new pageModel<userinfo>(5);//带一个参数的构造方法
			pm.setList(list);//list集合里面的数据 给工具类的属性
			pm.setCurrentPage(PageNo);//设置当前页
			pm.setSumCount(sumcount);//调用获取总记录数的方法得到总记录数
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.getClose1(conn, cs, rs);
		}
		return pm;
		
	}
}
