package com.keyholesoftware.demo.archunit.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.keyholesoftware.demo.archunit.domain.DomainObject;

@NoRepositoryBean
public interface DomainObjectRepository<T extends DomainObject, ID> extends JpaRepository<T, Long> {
  
  List<T> findAll(Sort sort);
  Page<T> findAll(Pageable pageable);
  
  List<T> findAll();               

  long count();                        

  void delete(T entity);               

}
