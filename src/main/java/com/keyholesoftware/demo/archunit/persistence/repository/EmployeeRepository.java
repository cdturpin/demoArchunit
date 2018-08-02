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

  @Override
  public List<Employee> findAllById(Iterable<Long> ids) {

    return null;
  }

  @Override
  public <S extends Employee> List<S> saveAll(Iterable<S> entities) {

    return null;
  }

  @Override
  public void flush() {

    
  }

  @Override
  public <S extends Employee> S saveAndFlush(S entity) {

    return null;
  }

  @Override
  public void deleteInBatch(Iterable<Employee> entities) {

    
  }

  @Override
  public void deleteAllInBatch() {

    
  }

  @Override
  public Employee getOne(Long id) {

    return null;
  }

  @Override
  public <S extends Employee> List<S> findAll(Example<S> example) {

    return null;
  }

  @Override
  public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {

    return null;
  }

  @Override
  public void deleteAll() {

    
  }

  @Override
  public void deleteAll(Iterable<? extends Employee> arg0) {

    
  }

  @Override
  public void deleteById(Long arg0) {

    
  }

  @Override
  public boolean existsById(Long arg0) {

    return false;
  }

  @Override
  public Optional<Employee> findById(Long arg0) {

    return null;
  }

  @Override
  public <S extends Employee> S save(S arg0) {

    return null;
  }

  @Override
  public <S extends Employee> long count(Example<S> arg0) {

    return 0;
  }

  @Override
  public <S extends Employee> boolean exists(Example<S> arg0) {

    return false;
  }

  @Override
  public <S extends Employee> Page<S> findAll(Example<S> arg0, Pageable arg1) {

    return null;
  }

  @Override
  public <S extends Employee> Optional<S> findOne(Example<S> arg0) {

    return null;
  }

  @Override
  public List<Employee> findAll(Sort sort) {

    return null;
  }

  @Override
  public Page<Employee> findAll(Pageable pageable) {

    return null;
  }

  @Override
  public List<Employee> findAll() {

    return null;
  }

  @Override
  public long count() {

    return 0;
  }

  @Override
  public void delete(Employee entity) {

    
  }

  
//    @Query(value = "SELECT E FROM EMPLOYEES E WHERE E.EMAIL_ADDRESS = :emailAddress", nativeQuery = true)
//    Employee findByEmailAddress(String emailAddress);
//    
//    @Query("SELECT E FROM EMPLOYEES E WHERE E.FIRSTNAME = :FIRSTNAME OR E.LASTNAME = :lastName")
//    Employee findByLastnameOrFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);
}