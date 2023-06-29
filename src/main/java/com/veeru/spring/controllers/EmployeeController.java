/**
 * 
 */
package com.veeru.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veeru.spring.dto.EmployeeDTO;
import com.veeru.spring.exceptionhandlers.ObjectNotFoundException;
import com.veeru.spring.services.EmployeeService;

/**
 * @author Virupaksha K
 *
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;

	@PutMapping("/save")
	public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO empDTO) {
		EmployeeDTO empfromDB = empService.saveEmp(empDTO);

		return new ResponseEntity<EmployeeDTO>(empfromDB, HttpStatus.CREATED);
	}

	@GetMapping("/getInfoById/{empId}")
	public ResponseEntity<EmployeeDTO> getEmployeeInfoById(@PathVariable Integer empId) throws ObjectNotFoundException {

		EmployeeDTO empfromDB = empService.getEmpInfoById(empId);

		return new ResponseEntity<EmployeeDTO>(empfromDB, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmpInfo/{empId}")
	public ResponseEntity<String> deleteEmployeeInfoById(@PathVariable Integer empId) throws ObjectNotFoundException {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Employee record deleted successfully.", HttpStatus.NO_CONTENT);
	}

	@GetMapping("/test/{name}")
	public String getMessage(@PathVariable String name) {
		return "Welcome to spring AOP concept:"+name;
	}
	
	@GetMapping("/greeting")
	public String getGreeting() {
		return "Hello Good day..!";
	}
}
