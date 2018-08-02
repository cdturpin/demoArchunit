package com.keyholesoftware.demo.archunit.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.keyholesoftware.demo.archunit.domain.Customer;
import com.keyholesoftware.demo.archunit.persistence.repository.DomainObjectRepository;

@Service
public class CustomerService implements ServiceInterface<Customer, Long> {

  public CustomerService() {
    super();
  }

  @Autowired
  DomainObjectRepository<Customer, Long> customerRepository;

  @Override
  public Collection<Customer> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Customer> findAll(Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<Customer> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<Customer> findById(Long primaryKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void delete(Customer entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean existsById(Long primaryKey) {
    // TODO Auto-generated method stub
    return false;
  }

}
