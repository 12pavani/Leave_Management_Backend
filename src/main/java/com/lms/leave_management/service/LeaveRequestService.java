package com.lms.leave_management.service;

import com.lms.leave_management.entity.LeaveRequest;
import com.lms.leave_management.entity.LeaveStatus;
import com.lms.leave_management.repo.LeaveRequestRepo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {
    private final LeaveRequestRepo leaveRepo;

    public LeaveRequestService(LeaveRequestRepo leaveRepo) {
        this.leaveRepo = leaveRepo;
    }

    public LeaveRequest applyLeave(LeaveRequest leave) {
        long days = ChronoUnit.DAYS.between(leave.getFromDate(), leave.getToDate()) + 1;
        leave.setNumberOfDays((int) days);

        leave.setDateApplied(LocalDate.now());
        leave.setLeaveStatus(LeaveStatus.APPLIED);

        return leaveRepo.save(leave);
    }

    public LeaveRequest verifyLeave(Long id, LeaveStatus status, String remarks) {
        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));

        leave.setLeaveStatus(status);
        leave.setRemarks(remarks);
        return leaveRepo.save(leave);
    }

    public LeaveRequest cancelLeave(Long id) {
        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setLeaveStatus(LeaveStatus.CANCELLED);
        return leaveRepo.save(leave);
    }

    public LeaveRequest withdrawLeave(Long id) {
        LeaveRequest leave = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Leave not found"));
        leave.setLeaveStatus(LeaveStatus.WITHDRAWN);
        return leaveRepo.save(leave);
    }

    public Optional<LeaveRequest> checkLeaveStatus(Long id) {
        return leaveRepo.findById(id);
    }

    public List<LeaveRequest> viewLeaveHistory(String empId) {
        return leaveRepo.findAll().stream()
                .filter(l -> l.getEmpId().equals(empId))
                .toList();
    }
}
