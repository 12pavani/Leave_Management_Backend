package com.lms.leave_management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "public_holidays")
public class PublicHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_seq")
    @SequenceGenerator(name = "holiday_seq", sequenceName = "holiday_sequence", allocationSize = 1)
    private Long id;

    private LocalDate holiday_date;

    private String holidayDetails;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return holiday_date;
    }

    public void setDate(LocalDate date) {
        this.holiday_date = date;
    }

    public String getHolidayDetails() {
        return holidayDetails;
    }

    public void setHolidayDetails(String holidayDetails) {
        this.holidayDetails = holidayDetails;
    }
}
