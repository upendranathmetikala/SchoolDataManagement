package com.StudentDataManagementController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.service.TeacherService;
import com.StudentDataManagement.service.TeacherServiceImp;
@WebServlet("/teacherlogin")
public class TeacherLoginServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		TeacherService service = new TeacherServiceImp();
		Teacher teacher = service.TeacherLogin(user, pass);
		
		if(teacher!=null) {
			resp.sendRedirect("http://localhost:8080/FullProject/TeacherLoginSuccess.html");
		}
		else {
			PrintWriter writer = resp.getWriter();
			writer.println("Invalid Details");
		}
	}
}
