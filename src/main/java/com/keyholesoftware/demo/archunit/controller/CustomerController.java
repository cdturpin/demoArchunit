package com.keyholesoftware.demo.archunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.keyholesoftware.demo.archunit.domain.Customer;
import com.keyholesoftware.demo.archunit.persistence.repository.DomainObjectRepository;
import com.keyholesoftware.demo.archunit.service.ServiceInterface;

public class CustomerController {
  
  @Autowired
  ServiceInterface<Customer, Long> customerService;
  @Autowired
  DomainObjectRepository<Customer, Long> customerRepository;
  
  @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
  public String addCustomer(@RequestParam("value") String value, Model model) {
     
      Customer customer = new Customer();
      customer.setValue(value);
     
      customerService.saveDetails(customer);
      model.addAttribute("result", "Your record inserted successfully");

      return null;//HOME_VIEW;
  }

}
