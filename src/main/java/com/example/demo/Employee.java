package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name = "employee")
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="name")
	private String name;
	@Column(name="salary")
	private Integer salary;
	@Column(name="experience")
	private int experience;
	@Column(name="address")
	private String address;
	@Column(name="phone_number")
	private long phoneNumber;
	@Column(name="nationality")
	private String nationality;
	@Column(name="martial_status")
	private boolean martialStatus;
	@Column(name="education")
	private String education;
	@Column(name="blood_group")
	private String bloodGroup;
	@Column(name="code")
	private String code; 
	@Column(name="DOJ")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date DateOfJoin;
	
	public Employee() {
		
	}
	
	public Employee(long id,String name,Integer salary,int experience,String address,long phone_number,String nationality,boolean martial_status,String education,String blood_group,String code,Date DateOfJoin) { 
	super();
	this.id=id;
	this.name =name;
	this.salary=salary;
	this.experience=experience;
	this.address=address;
	this.phoneNumber=phone_number;
	this.nationality=nationality;
	this.martialStatus=martial_status;
	this.education=education;
	this.bloodGroup=blood_group;
	this.code=code;
	this.DateOfJoin=DateOfJoin;
	
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone_number() {
		return phoneNumber;
	}
	public void setPhone_number(long phone_number) {
		this.phoneNumber = phone_number;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public boolean getMartial_status() {
		return martialStatus;
	}
	public void setMartial_status(boolean martial_status) {
		this.martialStatus = martial_status;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getBlood_group() {
		return bloodGroup;
	}
	public void setBlood_group(String blood_group) {
		this.bloodGroup = blood_group;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDateOfJoin() {
		return DateOfJoin;
	}
	public void setDateOfJoin(Date DateOfJoin) {
		this.DateOfJoin = DateOfJoin;
	
}
}