package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employeeController")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/emp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) throws EmployeeException{
		
		Employee output = empService.saveEmployee(emp);
		return new ResponseEntity<>(output,HttpStatus.CREATED);
	}
	
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmpDetails(@PathVariable("empId") Integer empId) throws EmployeeException{
		
		Employee output = empService.getEmpDetails(empId);
		return new ResponseEntity<>(output,HttpStatus.OK);
	
	}

}
