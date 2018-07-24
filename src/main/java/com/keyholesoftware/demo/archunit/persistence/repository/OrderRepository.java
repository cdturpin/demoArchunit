package com.keyholesoftware.demo.archunit.persistence.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.keyholesoftware.demo.archunit.domain.Order;

@Repository
@Transactional
@RepositoryRestResource
public interface OrderRepository extends DomainObjectRepository<Order> {


}