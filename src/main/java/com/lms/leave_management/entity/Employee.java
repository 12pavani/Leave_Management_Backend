package com.lms.leave_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee {

    @Id
    private String empId;  // SUTH25001

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String job;

    @Pattern(regexp="^[0-9]{10}$", message="Mobile number must be 10 digits")
    private String mobile;

    @Email
    private String email;

    private String managerId;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
    
    
}
