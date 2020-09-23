package com.mideros.simpleHttpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mideros.simpleHttpService.dto.Employee;
import com.mideros.simpleHttpService.dto.Role;
import com.mideros.simpleHttpService.service.IEmployeeService;

/**
 * Exercici Simple HTTP Service 
 * En aquesta pràctica aprendràs a crear peticions
 * HTTP amb un CRUD (Create, Read, Update, Delete) al complet. Per això
 * implementarem un patró d'arquitectura MVC amb repositoris. Enunciat: Crearem
 * un programa de gestió d'empleats molt senzill on depenent de la feina de
 * l'empleat se li assignarà un salari automàticament. D'un treballador
 * identifiquem el nom i la seva feina, estaria bé tenir un identificador únic
 * per aquest treballador. Les feines són fixes, és a dir ja estan definits en
 * un ENUMERABLE. Depenent de la feina s'assignarà un salari a l'empleat un cop
 * es crea.
 * 
 * @author Yohanna Mideros G.
 * @version 1.0
 */

@SpringBootApplication
public class SimpleHttpServiceApplication implements CommandLineRunner {

	@Autowired
	private IEmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SimpleHttpServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		employeeService.saveEmployee(new Employee( "Clint Eastwood", Role.Director));
		employeeService.saveEmployee(new Employee( "Oliver Stone", Role.Screenwriter));
		employeeService.saveEmployee(new Employee( "Jack Nicholson", Role.Actor));
		employeeService.saveEmployee(new Employee( "Gwyneth Paltrow", Role.Actress));
	}
}