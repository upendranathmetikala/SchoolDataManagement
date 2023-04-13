package com.StudentDataManagementController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.service.TeacherServiceImp;
@WebServlet("/getteacherdetails")

public class GetTeacherDetails extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherServiceImp ser = new TeacherServiceImp();
		List<Teacher> li = ser.getAllTeacher();
		HttpSession session = req.getSession();
		session.setAttribute("list", li);
		resp.sendRedirect("GetTeacherDetails.jsp");
	}
}
