package com.StudentDataManagement.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.StudentDataManagement.dto.Student;
import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.util.AppConstants;

public class TeacherRepositoryImp implements TeacherRepository {

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
	public Teacher TeacherLogin(String email, String password) {
		Connection con = getConnection();
		Teacher teacher=null;
		String query="SELECT * FROM teacher WHERE email=? AND password=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
			}
			con.close();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveTeacher(Teacher teacher) {
		Connection con = getConnection();
		String query="INSERT INTO teacher(name,email,contact,subject,class_teacher,salary,address,password)"
						+"VALUES(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getEmail());
			ps.setString(3, teacher.getContact());
			ps.setString(4, teacher.getSubject());
			ps.setString(5, teacher.getClassTeacher());
			ps.setString(6, teacher.getSalary());
			ps.setString(7, teacher.getAddress());
			ps.setString(8, teacher.getPassword());
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
	public Teacher deleteTeacher(int id) {
		Connection con = getConnection();
		Teacher teacher=null;
		String query="SELECT * FROM teacher WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
			}
			String query1="DELETE FROM teacher WHERE id=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, id);
			ps1.executeUpdate();
			con.close();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		Connection con = getConnection();
		Teacher teacher1=new Teacher();
		String query="UPDATE teacher SET name=?,email=?,contact=?,address=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, teacher.getName());
			ps.setString(2, teacher.getEmail());
			ps.setString(3, teacher.getContact());
			ps.setString(4, teacher.getAddress());
			ps.setInt(5, teacher.getId());
			ps.executeUpdate();
			String query1="SELECT * FROM teacher WHERE id=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, teacher.getId());
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				teacher1=new Teacher();
				teacher1.setId(rs.getInt(1));
				teacher1.setName(rs.getString(2));
				teacher1.setEmail(rs.getString(3));
				teacher1.setContact(rs.getString(4));
				teacher1.setSubject(rs.getString(5));
				teacher1.setClassTeacher(rs.getString(6));
				teacher1.setSalary(rs.getString(7));
				teacher1.setAddress(rs.getString(8));
				teacher1.setPassword(rs.getString(9));
			}
			con.close();
			return teacher1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Teacher getTeacherById(String id) {
		Connection con = getConnection();
		Teacher teacher=null;
		String query="SELECT * FROM teacher WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
			}
			con.close();
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) {
		Connection con = getConnection();
		Teacher teacher=null;
		List<Teacher> li=new ArrayList<Teacher>();
		String query="SELECT * FROM teacher WHERE subject=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, subject);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
				li.add(teacher);
			}
			con.close();
			if(li.toString()=="[]") return null;
			return li;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Teacher> getTeacherBySalary(int salary) {
		Connection con = getConnection();
		Teacher teacher=null;
		List<Teacher> li=new ArrayList<Teacher>();
		String query="SELECT * FROM teacher WHERE salary=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, salary);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
				li.add(teacher);
			}
			con.close();
			if(li.toString()=="[]") return null;
			return li;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Teacher> getClassTeacher(String std) {
		Connection con = getConnection();
		Teacher teacher=null;
		List<Teacher> li=new ArrayList<Teacher>();
		String query="SELECT * FROM teacher WHERE std=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, std);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
				li.add(teacher);
			}
			con.close();
			if(li.toString()=="[]") return null;
			return li;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		Connection con = getConnection();
		Teacher teacher=null;
		List<Teacher> li=new ArrayList<Teacher>();
		String query="SELECT * FROM teacher";
		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(query);
			while(rs.next()) {
				teacher=new Teacher();
				teacher.setId(rs.getInt(1));
				teacher.setName(rs.getString(2));
				teacher.setEmail(rs.getString(3));
				teacher.setContact(rs.getString(4));
				teacher.setSubject(rs.getString(5));
				teacher.setClassTeacher(rs.getString(6));
				teacher.setSalary(rs.getString(7));
				teacher.setAddress(rs.getString(8));
				teacher.setPassword(rs.getString(9));
				li.add(teacher);
			}
			con.close();
			if(li.toString()=="[]") return null;
			return li;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
