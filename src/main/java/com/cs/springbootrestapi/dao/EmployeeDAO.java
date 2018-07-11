package com.cs.springbootrestapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.springbootrestapi.model.Employee;
import com.cs.springbootrestapi.repository.EmployeeRepository;

@Service
public class EmployeeDAO 
{
	@Autowired
	EmployeeRepository employeeRepository;

	// save an employee
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	
	//search all employyee
	public List<Employee> find_all()
	{
		return employeeRepository.findAll();
	}
	
	
	//get an employee by Id
	public Employee findOne(Long empid)
	{
		return employeeRepository.findOne(empid);
	}
	
	
	
	//delete an employee by object
	public void delete(Employee emp)
	{
		employeeRepository.delete(emp);
	}


}
