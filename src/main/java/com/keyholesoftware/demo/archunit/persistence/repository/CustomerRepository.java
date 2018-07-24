package com.keyholesoftware.demo.archunit.persistence.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.keyholesoftware.demo.archunit.domain.Customer;

@Repository
@Transactional
public interface CustomerRepository extends DomainObjectRepository<Customer> {
   
    
    @Query(value = "SELECT C FROM CUSTOMERS C WHERE C.EMAIL_ADDRESS = :emailAddress", nativeQuery = true)
    Customer findByEmailAddress(String emailAddress);
    
    @Query("SELECT C FROM CUSTOMERS C WHERE C.FIRSTNAME = :firstName OR C.LASTNAME = :lastName")
    Customer findByLastNameOrFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    @PersistenceContext 
    EntityManager entityManager;
    
    public EntityManager getEntityManager() {
      return entityManager;
    }
    
    public void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
    }

    default void save(Customer customer) {
      this.entityManager.persist(customer);
    }

    @Override
    public List<Customer> findAll() {
       CriteriaQuery<Customer> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Customer.class);
       @SuppressWarnings("unused")
       Root<Customer> root = criteriaQuery.from(Customer.class);
       return entityManager.createQuery(criteriaQuery).getResultList();
    }
    

    <S extends T> S save(T t) {
       em.persist(t);
    }

    
    default List<T> findAll() {
       CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(T.class);
       @SuppressWarnings("unused")
       Root<T> root = criteriaQuery.from(Class<T> entity);
       return entityManager.createQuery(criteriaQuery).getResultList();
    }
}