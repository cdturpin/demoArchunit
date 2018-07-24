package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Embeddable
public class EmployeeDetails {

    Address employeeAddress;

    @Column(name = "email")
    String email;

    @Column(name = "job_title")
    String jobTitle;

    @Column(name = "department")
    String department;

    @Column(name = "manager_id")
    Integer managerId;

    @Column(name = "phone")
    Long phone;

    @Embedded
    public Address getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(Address employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    @OneToOne
    public String getAddress1() {
        return getEmployeeAddress().getAddress1();
    }

    public void setAddress1(String address1) {
        getEmployeeAddress().setAddress1(address1);
    }

    @OneToOne
    public String getAddress2() {
        return getEmployeeAddress().getAddress2();
    }

    public void setAddress2(String address2) {
        getEmployeeAddress().setAddress2(address2);
    }

    @OneToOne
    public String getCity() {
        return getEmployeeAddress().getCity();
    }

    public void setCity(String city) {
        getEmployeeAddress().setCity(city);
    }

    @OneToOne
    public String getState() {
        return getEmployeeAddress().getState();
    }

    public void setState(String state) {
        getEmployeeAddress().setState(state);
    }

    @OneToOne
    public Long getPostalCode() {
        return getEmployeeAddress().getPostalCode();
    }

    public void setPostalCode(Long postalCode) {
        getEmployeeAddress().setPostalCode(postalCode);
    }

    @OneToOne
    public String getCountry() {
        return getEmployeeAddress().getCountry();
    }

    public void setCountry(String country) {
        getEmployeeAddress().setCountry(country);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

}
