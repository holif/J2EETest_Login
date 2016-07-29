package xyz.baal.service;

import java.util.List;

import xyz.baal.dao.DelStudentInfoDao;
import xyz.baal.dao.GetStudentInfoDao;
import xyz.baal.dao.InsertStudentInfoDao;
import xyz.baal.dao.UpdateStudentInfoDao;
import xyz.baal.entity.Student;
/**
 * Student  service class
 */
public class StudentService {
	public static boolean insertStuInfo(Student stu){
		boolean flg = InsertStudentInfoDao.insertInfo(stu);
		return flg;
	}
	public static boolean updateInfoByStuNo(Student student){
		boolean flg = UpdateStudentInfoDao.updateStudent(student);
		return flg;
	}
	public static Student getInfoByStuno(String stuno){
		Student stu = GetStudentInfoDao.getInfoBystuNo(stuno);
		return stu;
	}
	public static List<Student> getAllStudents(){
		List<Student> list = GetStudentInfoDao.getAllInfo();
		return list;
	}
	public static List<Student> getPageStudents(int a,int b){
		List<Student> list = GetStudentInfoDao.getPageStudentsInfo(a,b);
		return list;
	}
	public static int getTotalPage(int DATA_PER_PAGE){
		return GetStudentInfoDao.getTotalPage(DATA_PER_PAGE);
	}
	public static boolean delStuByNo(String stuno){
		boolean flg = DelStudentInfoDao.deleteInfo(stuno);
		return flg;
	}
}
