/**
 * 
 */
package com.veeru.spring.services;

import com.veeru.spring.dto.EmployeeDTO;

/**
 * @author Virupaksha K
 *
 */
public interface EmployeeService {

	public EmployeeDTO saveEmp(EmployeeDTO empDto);

	public EmployeeDTO getEmpInfoById(Integer Id);
}
