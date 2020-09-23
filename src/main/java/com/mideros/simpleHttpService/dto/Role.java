package com.mideros.simpleHttpService.dto;

public enum Role {

	Director(13000), Actress(8602.32), Actor(9514.51), Screenwriter(4437.50);

	private double salary;

	private Role(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}
}
