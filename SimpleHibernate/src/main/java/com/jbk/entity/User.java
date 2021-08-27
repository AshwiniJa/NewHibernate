package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ojt_user")
public class User {

	@Id
	@Column(unique=true)
	private int id;
	private String name;
	private String city;
	private String phone;
	private String department;
	
	@Column
	private double salary;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String city, String phone, String department, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phone = phone;
		this.department = department;
		this.salary = salary;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", city=" + city + ", phone=" + phone + ", department="
				+ department + ", salary=" + salary + "]";
	}
	
}
