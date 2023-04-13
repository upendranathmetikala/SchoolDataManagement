package com.StudentDataManagement.service;

import java.sql.Connection;

import com.StudentDataManagement.dto.Admin;
import com.StudentDataManagement.repository.AdminRepository;
import com.StudentDataManagement.repository.AdminRepositoryImp;
import com.StudentDataManagement.util.AES;
import com.StudentDataManagement.util.AppConstants;

public class AdminServiceImp implements AdminService{
	AdminRepository repository;
	{
		repository=new AdminRepositoryImp();
	}
	
	@Override
	public Connection getConnection() {
		return null;
	}

	@Override
	public String saveAdmin(Admin admin) {
		String encPassword=AES.encrypt(admin.getPassword(), AppConstants.SECRETKEY);
		admin.setPassword(encPassword);
		
		return repository.saveAdmin(admin);
	}

	@Override
	public Admin adminLogin(String adminName, String password) {
		String p=AES.encrypt(password, AppConstants.SECRETKEY);
		Admin admin = repository.adminLogin(adminName, p);
		if(admin==null){
			return null;
		}
		String decPassword=AES.decrypt(admin.getPassword(), AppConstants.SECRETKEY);
		admin.setPassword(decPassword);
		return admin;
	}

}
