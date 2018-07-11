package com.cs.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cs.springbootrestapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
