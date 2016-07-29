package xyz.baal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xyz.baal.service.StudentService;


public class DelServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DelServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String stuNo = request.getParameter("studentno");
		boolean flg = StudentService.delStuByNo(stuNo);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(flg)
			out.println("ok");
		else 
			out.println("fail");
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
