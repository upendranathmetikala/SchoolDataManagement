package com.StudentDataManagementController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.service.TeacherServiceImp;
@WebServlet("/getmydetails")
public class GetMyDetailsTeacherServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		TeacherServiceImp ser = new TeacherServiceImp();
		Teacher teacher = ser.getTeacherById(id);
		HttpSession session = req.getSession();
		session.setAttribute("teacher", teacher);
		resp.sendRedirect("GetDetailsById.jsp");
	}
}
