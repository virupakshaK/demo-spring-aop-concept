/**
 * 
 */
package com.veeru.spring.services;

import com.veeru.spring.dto.EmployeeDTO;
import com.veeru.spring.exceptionhandlers.ObjectNotFoundException;

/**
 * @author Virupaksha K
 *
 */
public interface EmployeeService {

	public EmployeeDTO saveEmp(EmployeeDTO empDto);

	public EmployeeDTO getEmpInfoById(Integer Id) throws ObjectNotFoundException;
	
	public void deleteEmployeeById(Integer id) throws ObjectNotFoundException;
}
