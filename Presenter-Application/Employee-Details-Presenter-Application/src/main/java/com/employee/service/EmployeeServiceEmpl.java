package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeDao;

@Service
public class EmployeeServiceEmpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	@Override
	public Employee saveEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee employee = empDao.save(emp);

		if (employee == null) {
			throw new EmployeeException("employee not save");
		}

		return employee;
	}

	@Override
	public Employee getEmpDetails(Integer empId) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee employee = null;

		Optional<Employee> empOtp = empDao.findById(empId);
		if (empOtp.isPresent()) {
			employee = empOtp.get();

		} else {
			throw new EmployeeException("You have not entered correct empId" + empId);
		}
		return employee;
	}

}
