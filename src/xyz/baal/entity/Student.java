package xyz.baal.entity;


public class Student {
	private int id;
	private String studentNo;
	private String password;
	private String studentName;
	private String studentSex;
	public Student(){
		super();
	}
	public Student(String studentNo,String password,String studentName,String studentSex){
		this.studentNo = studentNo;
		this.password = password;
		this.studentName = studentName;
		this.studentSex = studentSex;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
}
