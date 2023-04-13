package com.StudentDataManagementController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentDataManagement.dto.Student;
import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.service.StudentServiceImp;
@WebServlet("/editstudent")
public class EditStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();
		student.setId(Integer.parseInt(req.getParameter("id")));
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setAddress(req.getParameter("address"));
		StudentServiceImp ser = new StudentServiceImp();
		Student t = ser.updateStudent(student);
		PrintWriter writer = resp.getWriter();
		if(t!=null) {
			writer.println("data updated successfully");
		}
		else {
			writer.println("invalid id");
		}
	}
}
