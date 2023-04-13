package com.StudentDataManagement.repository;
import java.sql.Connection;

import java.util.List;

import com.StudentDataManagement.dto.Teacher;

public interface TeacherRepository {
	
	Connection getConnection();
	Teacher TeacherLogin(String email,String password);
	String saveTeacher(Teacher teacher);
	Teacher deleteTeacher(int id);
	Teacher updateTeacher(Teacher teacher);
	Teacher getTeacherById(String id);
	List<Teacher> getTeacherBySubject(String subject);
	List<Teacher> getTeacherBySalary(int salary);
	List<Teacher> getClassTeacher(String std);
	List<Teacher> getAllTeacher();
}
