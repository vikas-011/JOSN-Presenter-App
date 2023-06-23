package com.employee.service;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp) throws EmployeeException;
	public Employee getEmpDetails(Integer empId) throws EmployeeException;
}
