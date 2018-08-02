package com.keyholesoftware.demo.archunit.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.keyholesoftware.demo.archunit.domain.Employee;

@Repository
@Transactional
@RepositoryRestResource
public class EmployeeRepository implements DomainObjectRepository<Employee, Long> {

  public EmployeeRepository() {
    super();
  }

  @Override
  public List<Employee> findAll(Iterable<Long> ids) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Employee> List<S> save(Iterable<S> entities) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void flush() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public <S extends Employee> S saveAndFlush(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteInBatch(Iterable<Employee> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAllInBatch() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Employee getOne(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Employee> List<S> findAll(Example<S> example) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Employee> S save(S entity) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Employee findOne(Long id) {
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
  public void delete(Iterable<? extends Employee> entities) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteAll() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public <S extends Employee> S findOne(Example<S> example) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public <S extends Employee> long count(Example<S> example) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public <S extends Employee> boolean exists(Example<S> example) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<Employee> findAll(Sort sort) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Page<Employee> findAll(Pageable pageable) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Optional<Employee> findById(Long primaryKey) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Employee> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long count() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void delete(Employee entity) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean existsById(Long primaryKey) {
    // TODO Auto-generated method stub
    return false;
  }
//    @Query(value = "SELECT E FROM EMPLOYEES E WHERE E.EMAIL_ADDRESS = :emailAddress", nativeQuery = true)
//    Employee findByEmailAddress(String emailAddress);
//    
//    @Query("SELECT E FROM EMPLOYEES E WHERE E.FIRSTNAME = :FIRSTNAME OR E.LASTNAME = :lastName")
//    Employee findByLastnameOrFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);
}