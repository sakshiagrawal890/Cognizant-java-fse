package com.cognizant.demo;

import com.cognizant.demo.model.Employee;
import com.cognizant.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class EmployeeDemoApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDemoApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EmployeeDemoApplication.class, args);
        LOGGER.info("Application Started");

        employeeService = context.getBean(EmployeeService.class);

        testAddEmployee();
        testGetAllEmployees();
    }

    private static void testAddEmployee() {
        LOGGER.info("--- Testing addEmployee (Spring Data JPA) ---");
        Employee emp = new Employee("Shakshi", "Engineering");
        employeeService.addEmployee(emp);
        LOGGER.info("Employee added successfully.");
    }

    private static void testGetAllEmployees() {
        LOGGER.info("--- Testing getAllEmployees ---");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.debug("employees={}", employees);
        LOGGER.info("Total employees fetched: {}", employees.size());
    }
}
