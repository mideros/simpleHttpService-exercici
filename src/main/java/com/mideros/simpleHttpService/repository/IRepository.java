package com.mideros.simpleHttpService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mideros.simpleHttpService.dto.Employee;
import com.mideros.simpleHttpService.dto.Role;

public interface IRepository extends JpaRepository<Employee, Integer> {

	List<Employee> findByRole(Role role);

}
