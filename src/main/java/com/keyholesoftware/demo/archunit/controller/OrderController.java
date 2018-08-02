package com.keyholesoftware.demo.archunit.controller;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keyholesoftware.demo.archunit.domain.Order;
import com.keyholesoftware.demo.archunit.service.ServiceInterface;

@RestController
public class OrderController {

  public static final Logger logger = LoggerFactory.getLogger(OrderController.class);

  @Autowired
  ServiceInterface<Order, Long> orderService;

  @RequestMapping(value = "{id}/addOrder")
  public String addOrder(@PathVariable("id") Long id,
      @RequestParam("orderDate") LocalDate orderDate, Model model) {
    System.out.println("Id:" + id);
    System.out.println("OrderDate:" + orderDate);
    Order order = new Order();
    order.setOrderId(1L);
    order.setOrderDate(new Date(0));
    //      id              INT NOT NULL,
    //      employee_id     INT ,
    //      customer_id     INT ,
    //      order_date      DATETIME ,
    //      shipped_date    DATETIME ,
    //      ship_name       VARCHAR(50) ,
    //      ship_address1   VARCHAR(150) ,
    //      ship_address2   VARCHAR(150) ,
    //      ship_city       VARCHAR(50) ,
    //      ship_state      VARCHAR(50) ,
    //      ship_postal_code VARCHAR(50) ,
    //      ship_country    VARCHAR(50) ,
    //      shipping_fee    DECIMAL(19,4) NULL DEFAULT '0.0000',
    //      payment_type    VARCHAR(50) ,
    //      paid_date       DATETIME ,
    //      order_status    VARCHAR(25),

    orderService.saveDetails(order);
    model.addAttribute("result", "Your record inserted successfully");

    return null;
  }

}
