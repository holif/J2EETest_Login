package xyz.baal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xyz.baal.entity.Student;
import xyz.baal.util.JDBCUtil;

/**
 * update student information 
 */
public class UpdateStudentInfoDao {
	/**
	 * 
	 * @param studentNo  
	 * @param pass      
	 * @return  		
	 */
	public static boolean updateStudent(Student stu){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
	    conn = JDBCUtil.getConnection();
		try {
			 pstmt = conn.prepareStatement("update student set password=?,studentName=?,studentSex=? where studentNo=?");
			 
			 pstmt.setString(1, stu.getPassword());
			 pstmt.setString(2,stu.getStudentName());
			 pstmt.setString(3, stu.getStudentSex());
			 pstmt.setString(4,stu.getStudentNo());
			 
			 i = pstmt.executeUpdate();		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn,null,pstmt,null);
		}
		if(i< 1){
			return false;
		 }
		return true;
	}
	public static boolean updatePassBystuNo(String studentNo,String pass){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
	    conn = JDBCUtil.getConnection();
		try {
			 pstmt = conn.prepareStatement("update student set password=? where studentNo=?");
			 pstmt.setString(1,pass);
			 pstmt.setString(2,studentNo);
			 i = pstmt.executeUpdate();		 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn,null,pstmt,null);
		}
		if(i< 1){
			return false;
		 }
		return true;
	}
}
