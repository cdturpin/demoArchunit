package com.keyholesoftware.demo.archunit.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "orders", schema="northwind")
public class Order extends DomainObject {
    
  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long orderId;
    
    @Column(name = "employee_id")
    Integer employeeId;
    
    @Column(name = "customer_id")
    Long customerId;
    
      
    @Column(name = "order_date")
    Date orderDate;
    
    @Column(name = "shipped_date")
    Date shippedDate;
    
    @Column(name = "ship_name")
    String shipName;
    
    Address shipAddress;
    
    @Column(name = "shipping_fee")
    Double shippingFee; //DEFAULT '0.0000',
    
    @Column(name = "payment_type")
    String paymentType;
    
    @Column(name = "paid_date")
    Date paidDate;
    
    @Column(name = "order_status")
    String orderStatus;
    
    @OneToMany(mappedBy="orders")
    Set<OrderDetail> orderDetailLine;
    @OneToOne
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    @OneToOne
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    @OneToOne
    public Long getCustomerId() {
        return customerId;
    }

    @OneToMany
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    @OneToOne
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    @OneToOne
    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
    @OneToOne
    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    @ManyToOne
    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }
    @OneToOne
    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    @OneToOne
    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
    @OneToOne
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    @ManyToOne
    public Set<OrderDetail> getOrderDetailLine() {
        return orderDetailLine;
    }

    public void setOrderDetailLine(Set<OrderDetail> orderDetailLine) {
        this.orderDetailLine = orderDetailLine;
    }
    
    @OneToOne
    @Embedded
    public Address getShipAddress() {
        return shipAddress;
    }
    
    public void setShipAddress(Address shipAddress) {
        this.shipAddress = shipAddress;
    }
    @OneToOne
    @Column(name = "ship_address1")
    public String getShipAddress1() {
        return getShipAddress().getAddress1();
    }

    public void setAddress1(String address1) {
        getShipAddress().setAddress1(address1);
    }
    @OneToOne
    @Column(name = "ship_address2")
    public String getAddress2() {
        return getShipAddress().getAddress2();
    }

    public void setAddress2(String address2) {
        getShipAddress().setAddress2(address2);
    }
    @OneToOne
    @Column(name = "ship_city")
    public String getCity() {
        return getShipAddress().getCity();
    }

    public void setCity(String city) {
        getShipAddress().setCity(city);
    }
    @OneToOne
    @Column(name = "ship_state")
    public String getState() {
        return getShipAddress().getState();
    }

    public void setState(String state) {
        getShipAddress().setState(state);
    }
    @OneToOne
    @Column(name = "ship_postal_code")
    public Long getPostalCode() {
        return getShipAddress().getPostalCode();
    }

    public void setPostalCode(Long postalCode) {
        getShipAddress().setPostalCode(postalCode);
    }
    @OneToOne
    @Column(name = "ship_country")
    public String getCountry() {
        return getShipAddress().getCountry();
    }

    public void setCountry(String country) {
        getShipAddress().setCountry(country);
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
    ); */

}
