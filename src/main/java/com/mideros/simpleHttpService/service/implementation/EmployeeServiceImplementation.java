package com.mideros.simpleHttpService.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mideros.simpleHttpService.dto.Employee;
import com.mideros.simpleHttpService.dto.Role;
import com.mideros.simpleHttpService.exception.ResourceNotFoundException;
import com.mideros.simpleHttpService.repository.IRepository;
import com.mideros.simpleHttpService.service.IEmployeeService;

@Service
public class EmployeeServiceImplementation implements IEmployeeService {

	@Autowired
	private IRepository employeeRepository;

	@Autowired
	public EmployeeServiceImplementation(IRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> listEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {	
						
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The employee with id "+id+ " does not exist"));
		
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		employee.setSalary(employee.getRole());
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findByRole(Role role) {

		return employeeRepository.findByRole(role);
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		employee.setSalary(employee.getRole());
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {

		employeeRepository.deleteById(id);
	}

}