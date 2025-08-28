package com.lms.leave_management.service;

import com.lms.leave_management.entity.Employee;
import com.lms.leave_management.repo.EmployeeRepo;

import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Optional<Employee> getEmployeeById(String empId) {
        return employeeRepo.findById(empId);
    }
}
