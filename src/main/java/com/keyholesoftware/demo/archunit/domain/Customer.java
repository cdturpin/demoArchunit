package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "customers", schema="northwind")
public class Customer extends DomainObject {
    
    public Customer() {
        super();
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long customerId; 
    
    @Column(name = "last_name")
    String lastName; 
    
    @Column(name = "first_name")
    String firstName; 
    
    @Column(name = "email")
    String email; 
    
    @Column(name = "company")
    String company; 
    
    @Column(name = "phone")
    Long phone; 
    
    Address customerAddress;
}

/*
 *  Table: customers
CREATE TABLE customers (
  id              INT NOT NULL,
  last_name       VARCHAR(50) ,
  first_name      VARCHAR(50) ,
  email           VARCHAR(50) ,
  company         VARCHAR(50) ,
  phone           VARCHAR(25) ,
  address1        VARCHAR(150),
  address2        VARCHAR(150),
  city            VARCHAR(50) ,
  state           VARCHAR(50) ,
  postal_code     VARCHAR(15) ,
  country         VARCHAR(50) ,
  PRIMARY KEY (id)
);



*/