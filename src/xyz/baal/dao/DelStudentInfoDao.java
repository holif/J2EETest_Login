package xyz.baal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import xyz.baal.util.JDBCUtil;

/**
 *  delete student information
 */
public class DelStudentInfoDao {

	public static boolean deleteInfo(String studentNo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i = 0;
	    conn = JDBCUtil.getConnection();
		try {
			 pstmt = conn.prepareStatement("delete from student where studentNo=?");
			 pstmt.setString(1,studentNo);
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
