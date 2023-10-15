package com.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.model.Employee;
import com.demo.app.model.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository EmployeeRepository;
	
	
	@GetMapping("employees")
	public List<Employee> getEmployees(){
		return this.EmployeeRepository.findAll();
	}
	 
	@Value("${VAR1:default1}")
	private String var1;
	
	@Value("${VAR2:default2}")
	private String var2;
	    
	@GetMapping("ping")
	 public String hello() {
        return "Hello here are some variables provided dynamically: " + var1 + " & " + var2;
    }
}
