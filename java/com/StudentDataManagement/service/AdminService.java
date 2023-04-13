package com.StudentDataManagement.service;

import java.sql.Connection;

import com.StudentDataManagement.dto.Admin;

public interface AdminService {
	Connection getConnection();
	String saveAdmin(Admin admin);
	Admin adminLogin(String adminName,String password);
}
