package com.lms.leave_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.leave_management.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {
}
