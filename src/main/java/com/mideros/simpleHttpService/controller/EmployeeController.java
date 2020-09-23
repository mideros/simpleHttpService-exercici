package com.mideros.simpleHttpService.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.mideros.simpleHttpService.dto.Employee;
import com.mideros.simpleHttpService.dto.Role;
import com.mideros.simpleHttpService.exception.ResourceNotFoundException;
import com.mideros.simpleHttpService.service.implementation.EmployeeServiceImplementation;

@RestController
@RequestMapping("/v1")

public class EmployeeController {

	@Autowired
	private EmployeeServiceImplementation employeeService;

	@GetMapping("/employees")
	public List<Employee> listEmployees() {
		return employeeService.listEmployees();
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {

		Employee emp = employeeService.saveEmployee(employee);

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> employeeById(@PathVariable(value = "id") int id) {

		Employee eById = employeeService.getEmployeeById(id);

		return new ResponseEntity<Employee>(eById, HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int id,
			@Valid @RequestBody Employee employee) throws ResourceNotFoundException {

		Employee oldDataEmployee = new Employee();
		Employee newDataEmployee = new Employee();

		oldDataEmployee = employeeService.getEmployeeById(id);
		oldDataEmployee.setFullName(employee.getFullName());
		oldDataEmployee.setRole(employee.getRole());

		newDataEmployee = employeeService.updateEmployee(oldDataEmployee);

		return new ResponseEntity<Employee>(newDataEmployee, HttpStatus.OK);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/employees/role/{role}")
	public ResponseEntity<List<Employee>> employeeByRole(@PathVariable(value = "role") Role role) {
		List<Employee> listByRole = employeeService.findByRole(role);
		return new ResponseEntity<List<Employee>>(listByRole, HttpStatus.OK);
	}

}