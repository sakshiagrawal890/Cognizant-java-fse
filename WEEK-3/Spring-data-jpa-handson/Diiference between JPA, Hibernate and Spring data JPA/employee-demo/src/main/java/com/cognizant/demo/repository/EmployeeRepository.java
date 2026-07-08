package com.cognizant.demo.repository;

import com.cognizant.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository - Spring Data JPA Repository
 *
 * By extending JpaRepository<Employee, Integer>, we automatically get:
 *  - save(employee)       → INSERT / UPDATE
 *  - findById(id)         → SELECT by primary key
 *  - findAll()            → SELECT all records
 *  - delete(employee)     → DELETE
 *  - count()              → SELECT COUNT(*)
 *
 * No implementation class is needed — Spring generates it at runtime!
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
