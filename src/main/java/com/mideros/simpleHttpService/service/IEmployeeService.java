package com.mideros.simpleHttpService.service;

import java.util.List;
import com.mideros.simpleHttpService.dto.Employee;
import com.mideros.simpleHttpService.dto.Role;

public interface IEmployeeService {
	
	
	public List<Employee> listEmployees(); 
	
	public Employee getEmployeeById(int id); 
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> findByRole(Role role);
	
	public Employee updateEmployee(Employee employee); 
	
	public void deleteEmployee(int id);

}
