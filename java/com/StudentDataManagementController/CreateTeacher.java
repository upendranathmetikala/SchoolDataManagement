package com.StudentDataManagementController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.service.TeacherServiceImp;

@WebServlet("/createteacher")
public class CreateTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherServiceImp ser = new TeacherServiceImp();
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(req.getParameter("id")));
		teacher.setName(req.getParameter("name"));
		teacher.setEmail(req.getParameter("email"));
		teacher.setContact(req.getParameter("contact"));
		teacher.setSubject(req.getParameter("subject"));
		teacher.setClassTeacher(req.getParameter("classteacher"));
		teacher.setSalary(req.getParameter("salary"));
		teacher.setAddress(req.getParameter("address"));
		teacher.setPassword(req.getParameter("password"));
		String saveTeacher = ser.saveTeacher(teacher);
		PrintWriter writer = resp.getWriter();
		if(saveTeacher!=null) {
			writer.println(saveTeacher);
		}
		else writer.println("invalid details");
		
	}
}
