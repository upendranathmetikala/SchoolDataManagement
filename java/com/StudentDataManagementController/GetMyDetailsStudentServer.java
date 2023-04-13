package com.StudentDataManagementController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentDataManagement.dto.Student;
import com.StudentDataManagement.service.StudentServiceImp;

@WebServlet("/getmydetailsstudent")
public class GetMyDetailsStudentServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentServiceImp ser = new StudentServiceImp();
		Student student = ser.getStudentById(id);
		HttpSession session = req.getSession();
		session.setAttribute("student", student);
		resp.sendRedirect("GetStudentById.jsp");
	}
}
