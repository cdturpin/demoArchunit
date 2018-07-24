package com.keyholesoftware.demo.archunit.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;



@Embeddable
@Entity
@Table(name = "OrderDetails", schema="northwind")
public class OrderDetail extends DomainObject {
    
   
  private static final long serialVersionUID = 1L;
    Long orderId;
    Long productId;
    Double quantity; //DEFAULT '0.0000',
    Double unitPrice; //DEFAULT '0.0000',
    Integer discount; //DEFAULT '0',
    String orderDetailStatus;
    Date dateAllocated;

public Long getOrderId() {
      return orderId;
    }
    public void setOrderId(Long orderId) {
      this.orderId = orderId;
    }
    public Long getProductId() {
      return productId;
    }
    public void setProductId(Long productId) {
      this.productId = productId;
    }
    public Double getQuantity() {
      return quantity;
    }
    public void setQuantity(Double quantity) {
      this.quantity = quantity;
    }
    public Double getUnitPrice() {
      return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
      this.unitPrice = unitPrice;
    }
    public Integer getDiscount() {
      return discount;
    }
    public void setDiscount(Integer discount) {
      this.discount = discount;
    }
    public String getOrderDetailStatus() {
      return orderDetailStatus;
    }
    public void setOrderDetailStatus(String orderDetailStatus) {
      this.orderDetailStatus = orderDetailStatus;
    }
    public Date getDateAllocated() {
      return dateAllocated;
    }
    public void setDateAllocated(Date dateAllocated) {
      this.dateAllocated = dateAllocated;
    }
    
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
    ); */
}
