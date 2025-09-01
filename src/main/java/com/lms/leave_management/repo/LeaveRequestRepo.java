package com.lms.leave_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.leave_management.entity.LeaveRequest;
import com.lms.leave_management.entity.LeaveStatus;

import java.util.List;

public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmpId(String empId);

    List<LeaveRequest> findByManagerId(String managerId);

    List<LeaveRequest> findByLeaveStatus(LeaveStatus leaveStatus);
}
