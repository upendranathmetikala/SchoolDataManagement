package com.StudentDataManagement.repository;

import java.sql.Connection;


import com.StudentDataManagement.dto.Admin;

public interface AdminRepository {
	
	Connection getConnection();
	String saveAdmin(Admin admin);
	Admin adminLogin(String adminName,String password);
}
