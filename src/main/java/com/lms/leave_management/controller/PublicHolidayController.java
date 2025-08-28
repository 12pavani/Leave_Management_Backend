package com.lms.leave_management.controller;

import com.lms.leave_management.entity.PublicHoliday;
import com.lms.leave_management.service.PublicHolidayService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/holiday")
public class PublicHolidayController {

    private final PublicHolidayService holidayService;
    public PublicHolidayController(PublicHolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping("/addholidaydetails")
    public ResponseEntity<PublicHoliday> addHoliday(@RequestBody PublicHoliday holiday) {
        return ResponseEntity.ok(holidayService.addHoliday(holiday));
    }

    @GetMapping("/viewholidaylist")
    public ResponseEntity<List<PublicHoliday>> viewHolidays() {
        return ResponseEntity.ok(holidayService.viewHolidayList());
    }
}
