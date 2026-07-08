package com.cognizant.demo.service;

import com.cognizant.demo.model.Employee;
import com.cognizant.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * EmployeeService - Service Layer
 *
 * Demonstrates how Spring Data JPA eliminates boilerplate code:
 *  - No need to manually open/close sessions
 *  - No need to manually begin/commit/rollback transactions
 *  - @Transactional handles all transaction lifecycle automatically
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Add a new employee to the database.
     * Compare this with the raw Hibernate approach which required 15+ lines of boilerplate.
     * Here, ONE line does the same work!
     */
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * Fetch all employees from the database.
     */
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
