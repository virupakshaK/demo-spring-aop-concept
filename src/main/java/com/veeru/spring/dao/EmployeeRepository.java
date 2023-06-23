/**
 * 
 */
package com.veeru.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veeru.spring.models.Employee;

/**
 * @author Virupaksha K
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
