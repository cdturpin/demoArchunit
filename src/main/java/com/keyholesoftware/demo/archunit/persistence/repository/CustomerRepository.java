package com.keyholesoftware.demo.archunit.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.keyholesoftware.demo.archunit.domain.Customer;

@Repository
public class CustomerRepository implements DomainObjectRepository<Customer, Long> {

  public CustomerRepository() {
    super();
  }

  public List<Customer> findAll(Iterable<Long> ids) {

    return null;
  }

  public <S extends Customer> List<S> save(Iterable<S> entities) {

    return null;
  }

  @Override
  public void flush() {

    
  }

  @Override
  public <S extends Customer> S saveAndFlush(S entity) {

    return null;
  }

  @Override
  public void deleteInBatch(Iterable<Customer> entities) {

    
  }

  @Override
  public void deleteAllInBatch() {

    
  }

  @Override
  public Customer getOne(Long id) {

    return null;
  }

  @Override
  public <S extends Customer> List<S> findAll(Example<S> example) {

    return null;
  }

  @Override
  public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {

    return null;
  }

  @Override
  public <S extends Customer> S save(S entity) {

    return null;
  }

  public Customer findOne(Long id) {

    return null;
  }

  public boolean exists(Long id) {

    return false;
  }

  public void delete(Long id) {

    
  }

  public void delete(Iterable<? extends Customer> entities) {

    
  }

  @Override
  public void deleteAll() {

    
  }

  @Override
  public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {

    return null;
  }

  @Override
  public <S extends Customer> long count(Example<S> example) {

    return 0;
  }

  @Override
  public <S extends Customer> boolean exists(Example<S> example) {

    return false;
  }

  @Override
  public List<Customer> findAll(Sort sort) {

    return null;
  }

  @Override
  public Page<Customer> findAll(Pageable pageable) {

    return null;
  }

  @Override
  public Optional<Customer> findById(Long primaryKey) {

    return null;
  }

  @Override
  public List<Customer> findAll() {

    return null;
  }

  @Override
  public long count() {

    return 0;
  }

  @Override
  public void delete(Customer entity) {

    
  }

  @Override
  public boolean existsById(Long primaryKey) {

    return false;
  }

  @Override
  public List<Customer> findAllById(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteAll(Iterable<? extends Customer> arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteById(Long arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public <S extends Customer> Optional<S> findOne(Example<S> arg0) {
    // TODO Auto-generated method stub
    return null;
  }
   
    
   /* @Query(value = "SELECT C FROM CUSTOMERS C WHERE C.EMAIL_ADDRESS = :emailAddress", nativeQuery = true)
    Customer findByEmailAddress(String emailAddress);
    
    @Query("SELECT C FROM CUSTOMERS C WHERE C.FIRSTNAME = :firstName OR C.LASTNAME = :lastName")
    Customer findByLastNameOrFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    List<Customer> findByLastName(String lastName);*/
  
}