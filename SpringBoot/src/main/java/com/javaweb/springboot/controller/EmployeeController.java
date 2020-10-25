package com.javaweb.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.javaweb.springboot.exception.ResourceNotFoundException;
import com.javaweb.springboot.model.Employee;
import com.javaweb.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/a")
	public String get() {
		return "hello";
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("employee not exist with id = "+id));
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeNew){
		Employee employee = employeeRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("employee not exist with id = "+id));
		employee.setFirstName(employeeNew.getFirstName());
		employee.setLastName(employeeNew.getLastName());
		employee.setEmailId(employeeNew.getEmailId());

		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("employee not exist with id = "+id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}




	
	
}
