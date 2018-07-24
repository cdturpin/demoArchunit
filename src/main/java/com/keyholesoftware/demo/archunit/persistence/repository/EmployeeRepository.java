package com.keyholesoftware.demo.archunit.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.keyholesoftware.demo.archunit.domain.Employee;

@Repository
@Transactional
@RepositoryRestResource
public interface EmployeeRepository extends DomainObjectRepository<Employee> {
    @Query(value = "SELECT E FROM EMPLOYEES E WHERE E.EMAIL_ADDRESS = :emailAddress", nativeQuery = true)
    Employee findByEmailAddress(String emailAddress);
    
    @Query("SELECT E FROM EMPLOYEES E WHERE E.FIRSTNAME = :FIRSTNAME OR E.LASTNAME = :lastName")
    Employee findByLastnameOrFirstname(@Param("lastname") String lastname, @Param("firstname") String firstname);
}