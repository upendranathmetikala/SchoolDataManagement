package com.StudentDataManagementTest;

import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.service.TeacherService;
import com.StudentDataManagement.service.TeacherServiceImp;

public class Test {
	public static void main(String[] args) {
		TeacherService service = new TeacherServiceImp();

		Teacher s = new Teacher();
		s.setName("ravi");
		s.setEmail("ravi@gmail.com");
		s.setContact("8142838500");
		s.setSubject("maths");
		s.setClassTeacher("8");
		s.setSalary("25000");
		s.setAddress("ndvm");
		s.setPassword("124");
		System.out.println(service.getTeacherById("1"));
	}
}
