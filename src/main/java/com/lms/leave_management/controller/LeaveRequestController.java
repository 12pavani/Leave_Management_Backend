package com.lms.leave_management.controller;

import com.lms.leave_management.entity.LeaveRequest;
import com.lms.leave_management.entity.LeaveStatus;
import com.lms.leave_management.service.LeaveRequestService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveRequestController {

    private final LeaveRequestService leaveService;
    public LeaveRequestController(LeaveRequestService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/applyleaverequest")
    public ResponseEntity<LeaveRequest> applyLeave(@RequestBody LeaveRequest leave) {
        return ResponseEntity.ok(leaveService.applyLeave(leave));
    }

    @PutMapping("/verifyleaverequest/{id}")
    public ResponseEntity<LeaveRequest> verifyLeave(@PathVariable Long id,
                                                    @RequestParam LeaveStatus status,
                                                    @RequestParam String remarks) {
        return ResponseEntity.ok(leaveService.verifyLeave(id, status, remarks));
    }

    @PutMapping("/cancelleave/{id}")
    public ResponseEntity<LeaveRequest> cancelLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.cancelLeave(id));
    }

    @PutMapping("/withdrawleave/{id}")
    public ResponseEntity<LeaveRequest> withdrawLeave(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.withdrawLeave(id));
    }

    @GetMapping("/checkleaverequeststatus/{id}")
    public ResponseEntity<?> checkStatus(@PathVariable Long id) {
        return leaveService.checkLeaveStatus(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/viewleavehistory/{empId}")
    public ResponseEntity<List<LeaveRequest>> viewHistory(@PathVariable String empId) {
        return ResponseEntity.ok(leaveService.viewLeaveHistory(empId));
    }
}
