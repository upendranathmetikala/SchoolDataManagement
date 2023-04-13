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
import com.StudentDataManagement.util.AppConstants;

public class StudentRepositoryImp<E> implements StudentRepository{

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
	public Student studentLogin(String email, String password) {
		Connection con = getConnection();
		Student student=null;
		String query="SELECT * FROM student WHERE email=? AND password=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
			}
			con.close();
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveStudent(Student student) {
		Connection con = getConnection();
		String query="INSERT INTO student(name,email,std,sec,over_all_percentage,gender,parent_contact,remarks,address,password)"
						+"VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getStd());
			ps.setString(4, student.getSec());
			ps.setString(5, student.getOverAllPercentage());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getParentContact());
			ps.setString(8, student.getRemarks());
			ps.setString(9, student.getAddress());
			ps.setString(10, student.getPassword());
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
	public Student getStudentById(int id) {
		Connection con = getConnection();
		Student student=null;
		String query="SELECT * FROM student WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
			}
			con.close();
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student deleteStudent(int id) {
		Connection con = getConnection();
		Student student=null;
		String query="SELECT * FROM student WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
			}
			String query1="DELETE FROM student WHERE id=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, id);
			int res = ps1.executeUpdate();
			con.close();
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student updateStudent(Student student) {
		Connection con = getConnection();
		Student student1=new Student();
		String query="UPDATE student SET name=?,email=?,address=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setString(3, student.getStd());
			ps.setString(4, student.getSec());
			ps.setString(5, student.getOverAllPercentage());
			ps.setString(6, student.getGender());
			ps.setString(7, student.getParentContact());
			ps.setString(8, student.getRemarks());
			ps.setString(9, student.getAddress());
			ps.setString(10, student.getPassword());
			ps.setInt(11, student.getId());
			ps.executeUpdate();
			String query1="SELECT FROM student WHERE id=?";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, student.getId());
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
				student1=new Student();
				student1.setId(rs.getInt(1));
				student1.setName(rs.getString(2));
				student1.setEmail(rs.getString(3));
				student1.setStd(rs.getString(4));
				student1.setSec(rs.getString(5));
				student1.setOverAllPercentage(rs.getString(6));
				student1.setGender(rs.getString(7));
				student1.setParentContact(rs.getString(8));
				student1.setRemarks(rs.getString(9));
				student1.setAddress(rs.getString(10));
				student1.setPassword(rs.getString(11));
			}
			con.close();
			return student1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getStudentByStd(String std) {
		Connection con = getConnection();
		List<Student> li = null;
		Student student=null;
		String query="SELECT * FROM student WHERE std=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, std);
			ResultSet rs = ps.executeQuery();
			li = new ArrayList<>();
			while(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
				li.add(student);
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
	public List<Student> getStudentByStdAndSec(String std, String sec) {
		Connection con = getConnection();
		List<Student> li = null;
		Student student=null;
		String query="SELECT * FROM student WHERE std=? AND sec=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, std);
			ps.setString(2, sec);
			ResultSet rs = ps.executeQuery();
			li = new ArrayList<>();
			while(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
				li.add(student);
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
	public List<Student> getStudentBetweenPercentage(String lower, String high) {
		Connection con = getConnection();
		List<Student> li = null;
		Student student=null;
		String query="SELECT * FROM student WHERE (over_all_percentage BETWEEN ? AND ?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, lower);
			ps.setString(2, high);
			ResultSet rs = ps.executeQuery();
			li = new ArrayList<>();
			while(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
				li.add(student);
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
	public List<Student> getAllStudent() {
		Connection con = getConnection();
		List<Student> li = null;
		Student student=null;
		String query="SELECT * FROM student";
		try {
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery(query);
			li = new ArrayList<>();
			while(rs.next()) {
				student=new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setStd(rs.getString(4));
				student.setSec(rs.getString(5));
				student.setOverAllPercentage(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setParentContact(rs.getString(8));
				student.setRemarks(rs.getString(9));
				student.setAddress(rs.getString(10));
				student.setPassword(rs.getString(11));
				li.add(student);
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
