package com.StudentDataManagementController;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentDataManagement.dto.Admin;
import com.StudentDataManagement.service.AdminService;
import com.StudentDataManagement.service.AdminServiceImp;
@WebServlet("/adminlogin")

public class AdminLoginServer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		AdminService service = new AdminServiceImp();
		Admin admin = service.adminLogin(user, pass);
		
		if(admin!=null) {
			resp.sendRedirect("http://localhost:8080/FullProject/AdminLoginSuccess.html");
		}
		else {
			PrintWriter writer = resp.getWriter();
			writer.println("Invalid Details");
		}
	}
}
