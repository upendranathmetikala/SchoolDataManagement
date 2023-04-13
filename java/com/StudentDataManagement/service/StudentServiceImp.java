package com.StudentDataManagement.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.StudentDataManagement.dto.Student;
import com.StudentDataManagement.repository.StudentRepository;
import com.StudentDataManagement.repository.StudentRepositoryImp;
import com.StudentDataManagement.util.AES;
import com.StudentDataManagement.util.AppConstants;

public class StudentServiceImp implements StudentService{
	StudentRepository repository;
	{
		repository=new StudentRepositoryImp<>();
	}
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student studentLogin(String email, String password) {
		String e=AES.encrypt(email, AppConstants.SECRETKEY);
		String p=AES.encrypt(password, AppConstants.SECRETKEY);
		Student student = repository.studentLogin(e, p);
		String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student.getAddress(), AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student.getParentContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student.getPassword(), AppConstants.SECRETKEY);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		return student;
	}

	@Override
	public String saveStudent(Student student) {
		String encEmail=AES.encrypt(student.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.encrypt(student.getAddress(), AppConstants.SECRETKEY);
		String encParentContact=AES.encrypt(student.getParentContact(), AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(student.getPassword(), AppConstants.SECRETKEY);
		student.setEmail(encEmail);
		student.setAddress(encAddress);
		student.setParentContact(encParentContact);
		student.setPassword(encPassword);
		
		return repository.saveStudent(student);
	}

	@Override
	public Student getStudentById(int id) {
		Student student = repository.getStudentById(id);
		String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student.getAddress(), AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student.getParentContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student.getPassword(), AppConstants.SECRETKEY);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		return student;
	}

	@Override
	public Student deleteStudent(int id) {
		Student student = repository.deleteStudent(id);
		String decEmail=AES.decrypt(student.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student.getAddress(), AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student.getParentContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student.getPassword(), AppConstants.SECRETKEY);
		student.setEmail(decEmail);
		student.setAddress(decAddress);
		student.setParentContact(decParentContact);
		student.setPassword(decPassword);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		String email=AES.encrypt(student.getEmail(), AppConstants.SECRETKEY);
		String address=AES.encrypt(student.getAddress(), AppConstants.SECRETKEY);
		Student student1 = repository.updateStudent(student);
		String decEmail=AES.decrypt(student1.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(student1.getAddress(), AppConstants.SECRETKEY);
		String decParentContact=AES.decrypt(student1.getParentContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(student1.getPassword(), AppConstants.SECRETKEY);
		student1.setEmail(decEmail);
		student1.setAddress(decAddress);
		student1.setParentContact(decParentContact);
		student1.setPassword(decPassword);
		return student1;
	}

	@Override
	public List<Student> getStudentByStd(String std) {
		List<Student> li1=new ArrayList<>();
		List<Student> li = repository.getStudentByStd(std);
		ListIterator<Student> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Student next = listIterator.next();
			Student student = new Student();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(next.getParentContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			student.setId(next.getId());
			student.setGender(next.getGender());
			student.setOverAllPercentage(next.getOverAllPercentage());
			student.setRemarks(next.getRemarks());
			student.setSec(next.getSec());
			student.setStd(next.getStd());
			student.setName(next.getName());
			li1.add(student);
		}
		return li1;
	}

	@Override
	public List<Student> getStudentByStdAndSec(String std, String sec) {
		List<Student> li1=new ArrayList<>();
		List<Student> li = repository.getStudentByStdAndSec(std,sec);
		ListIterator<Student> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Student next = listIterator.next();
			Student student = new Student();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(next.getParentContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			student.setId(next.getId());
			student.setGender(next.getGender());
			student.setOverAllPercentage(next.getOverAllPercentage());
			student.setRemarks(next.getRemarks());
			student.setSec(next.getSec());
			student.setStd(next.getStd());
			student.setName(next.getName());
			li1.add(student);
		}
		return li1;
	}

	@Override
	public List<Student> getStudentBetweenPercentage(String lower, String high) {
		List<Student> li1=new ArrayList<>();
		List<Student> li = repository.getStudentBetweenPercentage(lower,high);
		ListIterator<Student> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Student next = listIterator.next();
			Student student = new Student();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(next.getParentContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			student.setId(next.getId());
			student.setGender(next.getGender());
			student.setOverAllPercentage(next.getOverAllPercentage());
			student.setRemarks(next.getRemarks());
			student.setSec(next.getSec());
			student.setStd(next.getStd());
			student.setName(next.getName());
			li1.add(student);
		}
		return li1;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> li1=new ArrayList<>();
		List<Student> li = repository.getAllStudent();
		ListIterator<Student> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Student next = listIterator.next();
			Student student = new Student();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decParentContact=AES.decrypt(next.getParentContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			student.setEmail(decEmail);
			student.setAddress(decAddress);
			student.setParentContact(decParentContact);
			student.setPassword(decPassword);
			student.setId(next.getId());
			student.setGender(next.getGender());
			student.setOverAllPercentage(next.getOverAllPercentage());
			student.setRemarks(next.getRemarks());
			student.setSec(next.getSec());
			student.setStd(next.getStd());
			student.setName(next.getName());
			li1.add(student);
		}
		return li1;
	}

}
