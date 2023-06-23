/**
 * 
 */
package com.veeru.spring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.veeru.spring.dto.EmployeeDTO;
import com.veeru.spring.models.Employee;

/**
 * @author Virupaksha K
 *
 */
@Mapper(componentModel = "spring", uses = {AddressMapper.class})
public interface EmployeeMapper {

	@Mapping(target = "empId", source = "id")
	@Mapping(target = "addressDTO", source = "address")
	//@SubclassMapping(target = AddressDTO.class, source = Address.class)
	public EmployeeDTO toEmployeeDTO(Employee emp);

	@Mapping(target = "id", source = "empId")
	@Mapping(target = "address", source = "addressDTO")
	//@SubclassMapping(target = Address.class, source = AddressDTO.class)
	public Employee fromEmployeeDTO(EmployeeDTO empDto);
}
