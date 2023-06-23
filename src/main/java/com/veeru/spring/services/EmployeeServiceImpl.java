/**
 * 
 */
package com.veeru.spring.services;

import java.util.Optional;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veeru.spring.dao.EmployeeRepository;
import com.veeru.spring.dto.EmployeeDTO;
import com.veeru.spring.mapper.EmployeeMapper;
import com.veeru.spring.models.Employee;

/**
 * @author Virupaksha K
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	EmployeeMapper mapper;

	@Override
	public EmployeeDTO saveEmp(EmployeeDTO empDto) {
        System.out.println("Address Value:"+empDto.getAddressDTO().getCountry());
		Employee emp = empRepo.save(mapper.fromEmployeeDTO(empDto));

		return mapper.toEmployeeDTO(emp);
	}

	@Override
	public EmployeeDTO getEmpInfoById(Integer Id) {
		Optional<Employee> emp = empRepo.findById(Id);
		return mapper.toEmployeeDTO(emp.get());
	}
}
