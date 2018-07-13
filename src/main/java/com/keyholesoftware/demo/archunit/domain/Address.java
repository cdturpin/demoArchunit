package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "addresses", schema="northwind")
public class Address {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long addressId;
    
    @Column(name = "address1")
    String address1; 
    
    @Column(name = "address2")
    String address2; 
    
    @Column(name = "city")
    String city; 
    
    @Column(name = "state")
    String state; 
    
    @Column(name = "postal_code")
    Long postalCode; 
    
    @Column(name = "country")
    String country;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    @OneToOne
    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @OneToOne
    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @OneToOne
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToOne
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @OneToOne
    public Long getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Long postalCode) {
        this.postalCode = postalCode;
    }

    @OneToOne
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
