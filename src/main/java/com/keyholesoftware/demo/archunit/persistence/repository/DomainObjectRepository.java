package com.keyholesoftware.demo.archunit.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.keyholesoftware.demo.archunit.domain.DomainObject;

public interface DomainObjectRepository<T extends DomainObject> extends CrudRepository<T, Long> {

    <S extends T> S save(DomainObject entity);
    
    <S extends T> List<S> save(Iterable<S> entities);
    
    T findOne(Long id);
    
    void delete(T t);

}
