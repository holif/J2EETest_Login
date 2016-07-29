package xyz.baal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xyz.baal.entity.Student;
import xyz.baal.util.JDBCUtil;

/**
 * get student information
 */
public class GetStudentInfoDao {
	/**
	 * get all student information
	 * @return student list
	 */
	public static List<Student> getAllInfo(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		Student s = null;
	    conn = JDBCUtil.getConnection();
		try {
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("select * from student");
			 String password="";
			 while(rs.next()){
				s = new Student();
				s.setStudentNo(rs.getString("studentNo"));
				
				password = rs.getString("password");
				byte [] temp = password.getBytes();
				password = new sun.misc.BASE64Encoder().encode(temp);
				s.setPassword(password);
				
				s.setStudentName(rs.getString("studentName"));
				s.setStudentSex(rs.getString("studentSex"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn,stmt,null,rs);
		}
		return list;
	}
	/**
	 *  get student information list
	 * @param cur   beginning the curth record
	 * @param cur1  to cur1 record end
	 * @return student information list
	 */
	public static List<Student> getPageStudentsInfo(int cur,int cur1){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		Student s = null;
		String sql="";
		int i = 1;
	    conn = JDBCUtil.getConnection();
		try {
			sql = "select * from student where 1 limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cur);
			pstmt.setInt(2, cur1);
			rs = pstmt.executeQuery();
			 String password="";
			 while(rs.next()){
				s = new Student();
				s.setId(cur+i);
				s.setStudentNo(rs.getString("studentNo"));
				
				password = rs.getString("password");
				byte [] temp = password.getBytes();
				password = new sun.misc.BASE64Encoder().encode(temp);
				s.setPassword(password);
				
				s.setStudentName(rs.getString("studentName"));
				s.setStudentSex(rs.getString("studentSex"));
				list.add(s);
				++i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(conn,null,pstmt,rs);
		}
		return list;
	}
	/**
	 * get student information by studentno
	 * @param studentNo
	 * @return student object
	 */
	public static Student getInfoBystuNo(String studentNo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student student = new Student();
	    conn = JDBCUtil.getConnection();
		try {
			 pstmt = conn.prepareStatement("select * from student where studentNo = ? ");
			 pstmt.setString(1,studentNo);
			 rs = pstmt.executeQuery();
			 if(rs.next()){
				 student.setStudentNo(rs.getString("studentNo"));
				 student.setPassword(rs.getString("password"));
				 //System.out.println(rs.getString("password"));
				 student.setStudentName(rs.getString("studentName"));
				 student.setStudentSex(rs.getString("studentSex"));
			 }
			 else {
				 return null;
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.close(conn,null,pstmt,rs);
		}
		return student;
	}
	/**
	 * get total pages
	 * @param DATA_PER_PAGE  single page Max 
	 * @return
	 */
	public static int getTotalPage(int DATA_PER_PAGE) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;
		try {
			sql = "select count(*) from student";

			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}	
			count = (int) Math.ceil((count + 1.0 - 1.0) / DATA_PER_PAGE);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn,null,pstmt,rs);
		}
		return count;
	}
}