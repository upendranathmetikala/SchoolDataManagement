package com.StudentDataManagementController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.StudentDataManagement.dto.Student;
import com.StudentDataManagement.service.StudentServiceImp;
@WebServlet("/getstudentdetails")
public class GetStudentDetailsServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentServiceImp ser = new StudentServiceImp();
		List<Student> li = ser.getAllStudent();
		HttpSession session = req.getSession();
		session.setAttribute("list", li);
		resp.sendRedirect("GetStudentDetails.jsp");
	}
}
