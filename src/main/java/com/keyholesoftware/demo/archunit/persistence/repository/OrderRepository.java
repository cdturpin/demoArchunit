package com.keyholesoftware.demo.archunit.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.keyholesoftware.demo.archunit.domain.Order;

@Repository
public class OrderRepository implements DomainObjectRepository<Order, Long> {
  
  public OrderRepository() {
    super();
  }

  @Override
  public List<Order> findAll(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Order> List<S> save(Iterable<S> entities) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public <S extends Order> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteInBatch(Iterable<Order> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAllInBatch() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Order getOne(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Order> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Order> S save(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Order findOne(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean exists(Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete(Iterable<? extends Order> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public <S extends Order> S findOne(Example<S> example) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Order> long count(Example<S> example) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public <S extends Order> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    return false;
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
  public List<Order> findAll() {
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