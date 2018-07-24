package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public enum Category {
    
    CAMERA("Camera"),
    LAPTOP("Laptop"),
    TABLET("Tablet"),
    PHONE("Phone");
    
    Category(String categoryType) {
        this.categoryType = categoryType;
    }

    private String categoryType;

    @Column(name = "category")
    public String getCategoryType() {
        return categoryType;
    }

    void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
