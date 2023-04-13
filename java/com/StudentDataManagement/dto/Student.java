package com.StudentDataManagement.dto;

public class Student {
	private int id;
	private String name;
	private String email;
	private String std;
	private String sec;
	private String overAllPercentage;
	private String gender;
	private String parentContact;
	private String remarks;
	private String address;
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getOverAllPercentage() {
		return overAllPercentage;
	}
	public void setOverAllPercentage(String overAllPercentage) {
		this.overAllPercentage = overAllPercentage;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getParentContact() {
		return parentContact;
	}
	public void setParentContact(String parentContact) {
		this.parentContact = parentContact;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", std=" + std + ", sec=" + sec
				+ ", overAllPercentage=" + overAllPercentage + ", gender=" + gender + ", parentContact=" + parentContact
				+ ", remarks=" + remarks + ", address=" + address + ", password=" + password + "]";
	}
	
	
}
