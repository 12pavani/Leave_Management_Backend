package com.lms.leave_management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.leave_management.entity.PublicHoliday;

public interface PublicHolidayRepo extends JpaRepository<PublicHoliday, Long> {}