package xyz.baal.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.baal.entity.Student;
import xyz.baal.service.StudentService;

/**
 * Update Servlet
 *
 */
public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = new  Student();
		String stuno = request.getParameter("stuno");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		
		student.setStudentNo(stuno);
		student.setPassword(pass);
		student.setStudentName(name);
		student.setStudentSex(sex);
		boolean flg = StudentService.updateInfoByStuNo(student);
		HttpSession  session = request.getSession();
		List<Student> list = StudentService.getAllStudents();
		session.setAttribute("list",list);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(flg){
			out.println("ok");
		} else {
			out.println("no");		
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
	}
}
