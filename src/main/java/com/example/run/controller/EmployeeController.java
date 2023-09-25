package com.example.run.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.run.model.Employee;
import com.example.run.repository.EmpoloyeeRepository;
import com.example.run.response.MessageEmployeeResponseee;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(value = "*")
public class EmployeeController {
	
	@Autowired
	EmpoloyeeRepository empoloyeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return empoloyeeRepository.findAll();
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empoloyeeRepository.save(employee);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id) {
		try {
			return new ResponseEntity<Employee>(empoloyeeRepository.findById(id).get(),HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		try {
			Employee existEmployee = empoloyeeRepository.findById(employee.getId()).get();
			
			existEmployee.setEmail(employee.getEmail());
			existEmployee.setFirstName(employee.getFirstName());
			existEmployee.setLastName(employee.getLastName());
			
			Employee updateE = empoloyeeRepository.save(existEmployee);
				
			return ResponseEntity.ok(updateE);	
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(value = "id") Long id) {
		empoloyeeRepository.deleteById(id);
		Map<String, Boolean> respon = new HashMap<>();
		respon.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(respon);
	}		
}
