package com.StudentDataManagement.service;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.StudentDataManagement.dto.Teacher;
import com.StudentDataManagement.repository.TeacherRepository;
import com.StudentDataManagement.repository.TeacherRepositoryImp;
import com.StudentDataManagement.util.AES;
import com.StudentDataManagement.util.AppConstants;

public class TeacherServiceImp implements TeacherService{
	TeacherRepository repository;
	{
		repository=new TeacherRepositoryImp();
	}
	
	@Override
	public Connection getConnection() {
		return null;
	}

	@Override
	public Teacher TeacherLogin(String email, String password) {
		String e=AES.encrypt(email, AppConstants.SECRETKEY);
		String p=AES.encrypt(password, AppConstants.SECRETKEY);
		Teacher teacher = repository.TeacherLogin(e, p);
		if(teacher==null) return null;
		String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String decContact=AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY);
		teacher.setEmail(decEmail);
		teacher.setAddress(decAddress);
		teacher.setContact(decContact);
		teacher.setPassword(decPassword);
		return teacher;
	}

	@Override
	public String saveTeacher(Teacher teacher) {
		String encEmail=AES.encrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String encAddress=AES.encrypt(teacher.getAddress(), AppConstants.SECRETKEY);
		String encContact=AES.encrypt(teacher.getContact(), AppConstants.SECRETKEY);
		String encPassword=AES.encrypt(teacher.getPassword(), AppConstants.SECRETKEY);
		teacher.setEmail(encEmail);
		teacher.setAddress(encAddress);
		teacher.setContact(encContact);
		teacher.setPassword(encPassword);
		
		return repository.saveTeacher(teacher);
	}

	@Override
	public Teacher deleteTeacher(int id) {
		Teacher teacher = repository.deleteTeacher(id);
		String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY);
		String decContact=AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY);
		teacher.setEmail(decEmail);
		teacher.setAddress(decAddress);
		teacher.setContact(decContact);
		teacher.setPassword(decPassword);
		return teacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		String email=AES.encrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String address=AES.encrypt(teacher.getAddress(), AppConstants.SECRETKEY);
		String contact=AES.encrypt(teacher.getContact(), AppConstants.SECRETKEY);
		teacher.setEmail(email);
		teacher.setContact(contact);
		teacher.setAddress(address);
		Teacher teacher1 = repository.updateTeacher(teacher);
		String decEmail=AES.decrypt(teacher1.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(teacher1.getAddress(), AppConstants.SECRETKEY);
		String decContact=AES.decrypt(teacher1.getContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(teacher1.getPassword(), AppConstants.SECRETKEY);
		teacher1.setEmail(decEmail);
		teacher1.setAddress(decAddress);
		teacher1.setContact(decContact);
		teacher1.setPassword(decPassword);
		return teacher1;
	}

	@Override
	public Teacher getTeacherById(String id) {
		Teacher teacher = repository.getTeacherById(id);
		String decEmail=AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY);
		String decAddress=AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY);
		String decContact=AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY);
		String decPassword=AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY);
		teacher.setEmail(decEmail);
		teacher.setAddress(decAddress);
		teacher.setContact(decContact);
		teacher.setPassword(decPassword);
		return teacher;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) {
		List<Teacher> li1=new ArrayList<>();
		List<Teacher> li = repository.getTeacherBySubject(subject);
		ListIterator<Teacher> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Teacher next = listIterator.next();
			Teacher teacher = new Teacher();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decContact=AES.decrypt(next.getContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);
			teacher.setPassword(decPassword);
			teacher.setClassTeacher(next.getClassTeacher());
			teacher.setId(next.getId());
			teacher.setName(next.getName());
			teacher.setSalary(next.getSalary());
			teacher.setSubject(next.getSubject());
			
			li1.add(teacher);
		}
		return li1;
	}

	@Override
	public List<Teacher> getTeacherBySalary(int salary) {
		List<Teacher> li1=new ArrayList<>();
		List<Teacher> li = repository.getTeacherBySalary(salary);
		ListIterator<Teacher> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Teacher next = listIterator.next();
			Teacher teacher = new Teacher();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decContact=AES.decrypt(next.getContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);
			teacher.setPassword(decPassword);
			teacher.setClassTeacher(next.getClassTeacher());
			teacher.setId(next.getId());
			teacher.setName(next.getName());
			teacher.setSalary(next.getSalary());
			teacher.setSubject(next.getSubject());
			
			li1.add(teacher);
		}
		return li1;
	}

	@Override
	public List<Teacher> getClassTeacher(String std) {
		List<Teacher> li1=new ArrayList<>();
		List<Teacher> li = repository.getClassTeacher(std);
		ListIterator<Teacher> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Teacher next = listIterator.next();
			Teacher teacher = new Teacher();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decContact=AES.decrypt(next.getContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);
			teacher.setPassword(decPassword);
			teacher.setClassTeacher(next.getClassTeacher());
			teacher.setId(next.getId());
			teacher.setName(next.getName());
			teacher.setSalary(next.getSalary());
			teacher.setSubject(next.getSubject());
			
			li1.add(teacher);
		}
		return li1;
	}

	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> li1=new ArrayList<>();
		List<Teacher> li = repository.getAllTeacher();
		ListIterator<Teacher> listIterator = li.listIterator();
		while(listIterator.hasNext()) {
			Teacher next = listIterator.next();
			Teacher teacher = new Teacher();
			String decEmail=AES.decrypt(next.getEmail(), AppConstants.SECRETKEY);
			String decAddress=AES.decrypt(next.getAddress(), AppConstants.SECRETKEY);
			String decContact=AES.decrypt(next.getContact(), AppConstants.SECRETKEY);
			String decPassword=AES.decrypt(next.getPassword(), AppConstants.SECRETKEY);
			teacher.setEmail(decEmail);
			teacher.setAddress(decAddress);
			teacher.setContact(decContact);
			teacher.setPassword(decPassword);
			teacher.setClassTeacher(next.getClassTeacher());
			teacher.setId(next.getId());
			teacher.setName(next.getName());
			teacher.setSalary(next.getSalary());
			teacher.setSubject(next.getSubject());
			
			li1.add(teacher);
		}
		return li1;
	}

}
