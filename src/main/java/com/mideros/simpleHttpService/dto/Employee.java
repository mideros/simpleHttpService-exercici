package com.mideros.simpleHttpService.dto;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "employee")
public class Employee{	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fullName", nullable = false, length = 255, unique = true)
	@NotNull
	@NotEmpty(message = "Name must not be empty")
	@Size(min = 2, max = 255, message = "Name should have atleast 2 characters")
	private String fullName;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false, length = 255)
	private Role role;

	@Column(name = "salary")
	private double salary;

	public Employee() {
	}

	public Employee( String fullName, Role role) {
		super();		
		this.fullName = fullName;
		this.role = role;
		this.salary = role.getSalary();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(Role role) {
		this.salary = role.getSalary();
	}
}
