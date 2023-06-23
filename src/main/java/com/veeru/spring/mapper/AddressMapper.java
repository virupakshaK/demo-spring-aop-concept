/**
 * 
 */
package com.veeru.spring.mapper;

import org.mapstruct.Mapper;

import com.veeru.spring.dto.AddressDTO;
import com.veeru.spring.models.Address;

/**
 * @author Virupaksha K
 *
 */
@Mapper
public interface AddressMapper {

	public AddressDTO toAddressDTO(Address address);

	public Address fromAddressDTO(AddressDTO addressDTO);
}
