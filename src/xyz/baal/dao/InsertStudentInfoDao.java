package xyz.baal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xyz.baal.entity.Student;
import xyz.baal.util.JDBCUtil;


public class InsertStudentInfoDao {

	public static boolean insertInfo(Student student){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
	    conn = JDBCUtil.getConnection();
		try {
			 pstmt = conn.prepareStatement("insert into student(studentNo,password,studentName,studentSex) values(?,?,?,?)");
			 pstmt.setString(1,student.getStudentNo());
			 pstmt.setString(2,student.getPassword());
			 pstmt.setString(3,student.getStudentName());
			 pstmt.setString(4,student.getStudentSex());
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
