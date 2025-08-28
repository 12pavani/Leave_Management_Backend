package com.lms.leave_management.service;

import com.lms.leave_management.entity.PublicHoliday;
import com.lms.leave_management.repo.PublicHolidayRepo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublicHolidayService {
    private final PublicHolidayRepo holidayRepo;

    public PublicHolidayService(PublicHolidayRepo holidayRepo) {
        this.holidayRepo = holidayRepo;
    }

    public PublicHoliday addHoliday(PublicHoliday holiday) {
        return holidayRepo.save(holiday);
    }

    public List<PublicHoliday> viewHolidayList() {
        return holidayRepo.findAll();
    }
}
