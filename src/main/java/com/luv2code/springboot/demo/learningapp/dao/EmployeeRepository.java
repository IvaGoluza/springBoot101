package com.luv2code.springboot.demo.learningapp.dao;

import com.luv2code.springboot.demo.learningapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
