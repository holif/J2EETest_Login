package xyz.baal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import xyz.baal.entity.Student;
import xyz.baal.service.StudentService;

/**
 * Register Servlet
 *
 */
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	/**
	 * get parameter from jsp page and instert to mysql
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String stuno = request.getParameter("studentno");
   		String pass = request.getParameter("passwd");
   		String stuname = request.getParameter("studentname");
   		String sex = request.getParameter("sex");
   		
   		Student stu = new Student(stuno,pass,stuname,sex);
   		boolean flg = StudentService.insertStuInfo(stu);
   		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(flg){
			out.println("success");
		} else {
			out.println("fail");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	public void init() throws ServletException {
	}
}
