package com.lms.leave_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.leave_management.entity.LeaveRequest;
import com.lms.leave_management.entity.LeaveStatus;

import java.util.List;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Long> {

    // Get all leave requests of an employee
    List<LeaveRequest> findByEmpId(String empId);

    // Get all leave requests assigned to a manager
    List<LeaveRequest> findByManagerId(String managerId);

    // Get all leave requests by status (APPLIED, APPROVED, etc.)
    List<LeaveRequest> findByLeaveStatus(LeaveStatus leaveStatus);
}
