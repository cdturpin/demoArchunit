package com.keyholesoftware.demo.archunit.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DomainObject implements Serializable {

  private static final long serialVersionUID = 1L;

    public DomainObject() {
        super();
    }

    public DomainObject(Long id) {
        super();
        this.id = id;
    }

    public DomainObject(String value) {
        super();
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
