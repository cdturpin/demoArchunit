package com.keyholesoftware.demo.archunit.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keyholesoftware.demo.archunit.domain.Order;
import com.keyholesoftware.demo.archunit.persistence.repository.DomainObjectRepository;

@Service
public class OrderService implements ServiceInterface<Order, Long> {

  public OrderService() {
    super();
  }

  @Autowired
  DomainObjectRepository<Order, Long> orderRepository;

@GetMapping("/orders")
public String handler(Model model) {
  model.addAttribute("orders", orderRepository.findAll());
  return "orders";
}

@Override
public Collection<Order> findAll() {
  // TODO Auto-generated method stub
  return null;
}

@Override
public List<Order> findAll(Sort sort) {
  // TODO Auto-generated method stub
  return null;
}

@Override
public Page<Order> findAll(Pageable pageable) {
  // TODO Auto-generated method stub
  return null;
}

@Override
public Optional<Order> findById(Long primaryKey) {
  // TODO Auto-generated method stub
  return null;
}

@Override
public long count() {
  // TODO Auto-generated method stub
  return 0;
}

@Override
public void delete(Order entity) {
  // TODO Auto-generated method stub
  
}

@Override
public boolean existsById(Long primaryKey) {
  // TODO Auto-generated method stub
  return false;
}

}
