package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "employees", schema="northwind")
public class Employee extends DomainObject {
    
    public Employee() {
        super();
        this.employeeId = super.getId();
    }
    
    @Id
    @Column(name = "id")
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


/* Table: orders 
CREATE TABLE orders (
  id              INT NOT NULL,
  employee_id     INT ,
  customer_id     INT ,
  order_date      DATETIME ,
  shipped_date    DATETIME ,
  ship_name       VARCHAR(50) ,
  ship_address1   VARCHAR(150) ,
  ship_address2   VARCHAR(150) ,
  ship_city       VARCHAR(50) ,
  ship_state      VARCHAR(50) ,
  ship_postal_code VARCHAR(50) ,
  ship_country    VARCHAR(50) ,
  shipping_fee    DECIMAL(19,4) NULL DEFAULT '0.0000',
  payment_type    VARCHAR(50) ,
  paid_date       DATETIME ,
  order_status    VARCHAR(25),
  PRIMARY KEY (id)
);

/* Table: order_details 
CREATE TABLE order_details (
  order_id            INT NOT NULL,
  product_id          INT ,
  quantity            DECIMAL(18,4) NOT NULL DEFAULT '0.0000',
  unit_price          DECIMAL(19,4) NULL DEFAULT '0.0000',
  discount            DOUBLE NOT NULL DEFAULT '0',
  order_detail_status VARCHAR(25),
  date_allocated      DATETIME ,
  PRIMARY KEY (order_id, product_id)
);

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