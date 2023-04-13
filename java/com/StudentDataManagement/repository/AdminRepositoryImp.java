package com.StudentDataManagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.StudentDataManagement.dto.Admin;
import com.StudentDataManagement.util.AppConstants;

public class AdminRepositoryImp implements AdminRepository {

	@Override
	public Connection getConnection() {
		try {
			Class.forName(AppConstants.DRIVERNAME);
			String url=AppConstants.DB_URL;
			String user=AppConstants.DB_USER;
			String password=AppConstants.DB_PASSWORD;
			Connection con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveAdmin(Admin admin) {
		Connection con = getConnection();
		String query="INSERT INTO admin(admin_name,password)"
						+"VALUES(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, admin.getAdminName());
			ps.setString(2, admin.getPassword());
			int res = ps.executeUpdate();
			con.close();
			return res+" row of data added successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Admin adminLogin(String adminName, String password) {
		Connection con = getConnection();
		Admin admin=null;
		String query="SELECT * FROM admin WHERE admin_name=? AND password=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, adminName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admin=new Admin();
				admin.setId(rs.getInt(1));
				admin.setAdminName(rs.getString(2));
				admin.setPassword(rs.getString(3));
			}
			con.close();
			return admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
