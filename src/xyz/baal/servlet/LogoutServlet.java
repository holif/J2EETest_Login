package xyz.baal.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Logout Servlet -- remove session attribute
 */
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}
	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("student")!=null){
			session.removeAttribute("student"); 
		}	
		response.sendRedirect("index.jsp");
	}

	public void init() throws ServletException {
	}

}
