package com.cs.springbootrestapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs.springbootrestapi.dao.EmployeeDAO;
import com.cs.springbootrestapi.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;

	// savve an employee into db
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp)
	{
		return employeeDAO.save(emp);
	}

	//get all emps
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeDAO.find_all();
	}
	
	//get emps by id
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long id)
	{
		Employee emp = employeeDAO.findOne(id);
		if(emp==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(emp);
	}
	
	
	//update emp by id
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long id ,@Valid @RequestBody Employee empDetails)
	{
		Employee emp = employeeDAO.findOne(id);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee = employeeDAO.save(emp);
		
		return ResponseEntity.ok().body(updateEmployee);
				
	}
	
	//delete the emp
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long id)
	{
		Employee emp = employeeDAO.findOne(id);
		if(emp==null)
		{
			return ResponseEntity.notFound().build();
		}
		
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
	}





}
