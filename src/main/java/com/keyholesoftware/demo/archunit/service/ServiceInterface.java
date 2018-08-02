package com.keyholesoftware.demo.archunit.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.keyholesoftware.demo.archunit.domain.DomainObject;

public interface ServiceInterface<T extends DomainObject, ID> {

  public default T saveDetails(T t) {
    System.out.println("Service saved: " + t);
    return t;
  }
  
  Collection<T> findAll();
  
  List<T> findAll(Sort sort);
  Page<T> findAll(Pageable pageable);
  
  Optional<T> findById(ID primaryKey); 
        
  long count();                        

  void delete(T entity);               

  boolean existsById(ID primaryKey);
}
