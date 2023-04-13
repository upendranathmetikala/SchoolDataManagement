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

@WebServlet("/editteacher")
public class EditTeacherServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher teacher = new Teacher();
		teacher.setId(Integer.parseInt(req.getParameter("id")));
		teacher.setName(req.getParameter("name"));
		teacher.setEmail(req.getParameter("email"));
		teacher.setContact(req.getParameter("contact"));
		teacher.setAddress(req.getParameter("address"));
		TeacherServiceImp ser = new TeacherServiceImp();
		Teacher t = ser.updateTeacher(teacher);
		PrintWriter writer = resp.getWriter();
		if(t!=null) {
			writer.println("data updated successfully");
		}
		else {
			writer.println("invalid id");
		}
	}
}
