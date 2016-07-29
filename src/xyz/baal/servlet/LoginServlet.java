package xyz.baal.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.baal.entity.Student;
import xyz.baal.service.StudentService;
/**
 * Login Servlet 
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 3965509737077480076L;
	private static final int DATA_PER_PAGE = 5;
	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost( request,  response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student stu = null;
		String stuno = "";
		String pass = "";
		HttpSession  session = request.getSession();

		if(request.getParameter("studentno")!=null){
			stuno = request.getParameter("studentno");
	   		pass = request.getParameter("password");	
	   		
	   		stu = StudentService.getInfoByStuno(stuno);  
	   		
	   		if(stu == null||!stu.getPassword().equals(pass)){
	   			response.sendRedirect(request.getContextPath());
	   			return;
	   		}
	   		session.setAttribute("student",stu);
			session.setMaxInactiveInterval(600);
		}

   		String cur = (String) request.getParameter("cur");
   		int cur_int=1;
   		if(cur!=null){
   			cur_int = Integer.parseInt(cur);
   		}

		List<Student> list1 = new ArrayList<Student>();
		
		list1 = StudentService.getPageStudents((cur_int - 1) * DATA_PER_PAGE, DATA_PER_PAGE);
		
		int totalPage = StudentService.getTotalPage(DATA_PER_PAGE);
		request.setAttribute("students", list1);
		request.setAttribute("totalPage", totalPage);

		RequestDispatcher rd = request.getRequestDispatcher("data.jsp");
		rd.forward(request, response);	
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
	}
}
