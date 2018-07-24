package com.keyholesoftware.demo.archunit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keyholesoftware.demo.archunit.persistence.repository.OrderRepository;


@RestController
public class OrderController {

  @Autowired
  private OrderRepository orderRepo;

  @GetMapping("/Orders")
  public String handler(Model model) {
    model.addAttribute("Order", orderRepo.findAll());
    return "Orders";
  }

}
