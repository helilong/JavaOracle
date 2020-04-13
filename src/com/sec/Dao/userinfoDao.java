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
 * �ṩ��Ա����ɾ�Ĳ�����ķ���
 * @author 13947
 *
 */
public class userinfoDao {
	
	//��ͨ��ѯ
	public ArrayList<userinfo> query(){
		//��������
		Connection conn =DBUtil.getconn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ArrayList<userinfo> list=new ArrayList<userinfo>();
		//����sql���
		String sql="select * from userinfo";
		try {
			
			//����Ԥ�������
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				//�ӽ������ȡ�����ݲ���װ��ʵ�弯��
				userinfo user=new userinfo(rs.getInt("id"), rs.getString("name"));
				//��ʵ���������ӵ�������
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
	 * �洢���� ʵ�ֲ�ѯ
	 * @return
	 */
	public ArrayList<userinfo> query1(){
		//��������
		Connection conn=DBUtil.getconn();
		CallableStatement cs=null;
		ResultSet rs=null;
		ArrayList<userinfo> list=new ArrayList<userinfo>();
		
		//����sql���
		String sql="{call pro_select(?)}";
		
		try {
			//����Ԥ�������
			cs=conn.prepareCall(sql);
			
			//ע�������������
			cs.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
			
			//ִ��
			cs.execute();
			
			//��ȡ���ݲ�����ֵ
			rs=(ResultSet)cs.getObject(1);
			
			while(rs.next()) {
				//�ӽ������ȡ�����ݲ���װ��ʵ�弯��
				userinfo user=new userinfo(rs.getInt("id"), rs.getString("name"));
				//��ʵ���������ӵ�������
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر�����
			DBUtil.getClose1(conn, cs, rs);
		}
		return list;
		
	}
	
	public int insert(userinfo user) {
		//��������
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
