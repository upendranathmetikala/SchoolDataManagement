package com.StudentDataManagementController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.StudentDataManagement.dto.Student;
import com.StudentDataManagement.service.StudentService;
import com.StudentDataManagement.service.StudentServiceImp;
@WebServlet("/studentlogin")
public class StudentLoginServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		StudentService service = new StudentServiceImp();
		Student student = service.studentLogin(user, pass);
		
		if(student!=null) {
			resp.sendRedirect("http://localhost:8080/FullProject/StudentLoginSuccess.html");
		}
		else {
			PrintWriter writer = resp.getWriter();
			writer.println("Invalid Details");
		}
	}
}
