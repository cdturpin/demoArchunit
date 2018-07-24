package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "employees", schema = "northwind")
public class Employee extends DomainObject {

  
  private static final long serialVersionUID = 1L;

    public Employee() {
        super();
        this.employeeId = super.getId();
    }

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long employeeId;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "avatar")
    String avatar;

    EmployeeDetails employeeDetails;

    @Embedded
    public EmployeeDetails getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(EmployeeDetails employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

    @OneToOne
    public Address getEmployeeAddress() {
        return getEmployeeDetails().getEmployeeAddress();
    }

    public void setEmployeeAddress(Address employeeAddress) {
        getEmployeeDetails().setEmployeeAddress(employeeAddress);
    }

    @OneToOne
    public String getEmployeeEmail() {
        return getEmployeeDetails().getEmail();
    }

    public void setEmployeeEmail(String email) {
        getEmployeeDetails().setEmail(email);
    }

    @OneToOne
    public String getEmployeeJobTitle() {
        return getEmployeeDetails().getJobTitle();
    }

    public void setEmployeeJobTitle(String jobTitle) {
        getEmployeeDetails().setJobTitle(jobTitle);
    }

    @OneToOne
    public String getEmployeeDepartment() {
        return getEmployeeDetails().getDepartment();
    }

    public void setEmployeeDepartment(String department) {
        getEmployeeDetails().setDepartment(department);
    }

    @OneToOne
    public Integer getEmployeeManagerId() {
        return getEmployeeDetails().getManagerId();
    }

    public void setEmployeeManagerId(Integer managerId) {
        getEmployeeDetails().setManagerId(managerId);
    }

    @OneToOne
    public Long getEmployeePhone() {
        return getEmployeeDetails().getPhone();
    }

    public void setEmployeePhone(Long phone) {
        getEmployeeDetails().setPhone(phone);
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name = "address1")
    public String getAddress1() {
        return getEmployeeDetails().getAddress1();
    }

    public void setAddress1(String address1) {
        getEmployeeDetails().setAddress1(address1);
    }

    @Column(name = "address2")
    public String getAddress2() {
        return getEmployeeDetails().getAddress2();
    }

    public void setAddress2(String address2) {
        getEmployeeDetails().setAddress2(address2);
    }

    @Column(name = "city")
    public String getCity() {
        return getEmployeeDetails().getCity();
    }

    public void setCity(String city) {
        getEmployeeDetails().setCity(city);
    }

    @Column(name = "state")
    public String getState() {
        return getEmployeeDetails().getState();
    }

    public void setState(String state) {
        getEmployeeDetails().setState(state);
    }

    @Column(name = "postal_code")
    public Long getPostalCode() {
        return getEmployeeDetails().getPostalCode();
    }

    public void setPostalCode(Long postalCode) {
        getEmployeeDetails().setPostalCode(postalCode);
    }

    @Column(name = "country")
    public String getCountry() {
        return getEmployeeDetails().getCountry();
    }

    public void setCountry(String country) {
        getEmployeeDetails().setCountry(country);
    }

}




/* Table: products 
CREATE TABLE products (
  id              INT NOT NULL,
  product_code    VARCHAR(25) ,
  product_name    VARCHAR(50) ,
  description     VARCHAR(250),
  standard_cost   DECIMAL(19,4) NULL DEFAULT '0.0000',
  list_price      DECIMAL(19,4) NOT NULL DEFAULT '0.0000',
  target_level    INT ,
  reorder_level   INT ,
  minimum_reorder_quantity INT ,
  quantity_per_unit VARCHAR(50) ,
  discontinued    TINYINT NOT NULL DEFAULT '0',
  category        VARCHAR(50),
  PRIMARY KEY (id)
);

 */