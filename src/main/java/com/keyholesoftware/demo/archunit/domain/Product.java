package com.keyholesoftware.demo.archunit.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products", schema = "northwind")
public class Product extends DomainObject { 

    public Product() {
    }
    
    @Id
    @Column(name = "productId", nullable = false, unique = true, updatable = false)
    private Long productId;
    
    @Column(name = "productCode", nullable = false, unique = true, updatable = false)
    String productCode;
    
    @Column(name = "productName", nullable = false, unique = false, updatable = true)
    String productName;
    
    @Column(name = "description", nullable = true, unique = false, updatable = true)
    String description;
    
    @Column(name = "standardCost", nullable = false, unique = false, updatable = true)
    Double standardCost; //DEFAULT '0.0000'
    
    @Column(name = "listPrice", nullable = false, unique = false, updatable = true)
    Double listPrice; //DEFAULT '0.0000'
    
    @Column(name = "targetLevel", nullable = false, unique = false, updatable = true)
    Integer targetLevel;
    
    @Column(name = "reorderLevel", nullable = false, unique = false, updatable = true)
    Integer reorderLevel;
    
    @Column(name = "minimumReorderQuantity", nullable = false, unique = false, updatable = true)
    Integer minimumReorderQuantity;
    
    @Column(name = "quantityPerUnit", nullable = false, unique = false, updatable = true)
    Integer quantityPerUnit;
    
    @Column(name = "discontinued", nullable = false, unique = false, updatable = true)
    Boolean discontinued; // DEFAULT 'FALSE',
    
    @Embedded
    Category category;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @OneToOne
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @OneToOne
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToOne
    public Double getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(Double standardCost) {
        this.standardCost = standardCost;
    }

    @OneToOne
    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    @OneToOne
    public Integer getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Integer targetLevel) {
        this.targetLevel = targetLevel;
    }

    @OneToOne
    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @OneToOne
    public Integer getMinimumReorderQuantity() {
        return minimumReorderQuantity;
    }

    public void setMinimumReorderQuantity(Integer minimumReorderQuantity) {
        this.minimumReorderQuantity = minimumReorderQuantity;
    }

    @OneToOne
    public Integer getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(Integer quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    @OneToOne
    public Boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(Boolean discontinued) {
        this.discontinued = discontinued;
    }

    @OneToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((category == null) ? 0 : category.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
        result = prime * result + ((listPrice == null) ? 0 : listPrice.hashCode());
        result = prime * result + ((minimumReorderQuantity == null) ? 0 : minimumReorderQuantity.hashCode());
        result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((quantityPerUnit == null) ? 0 : quantityPerUnit.hashCode());
        result = prime * result + ((reorderLevel == null) ? 0 : reorderLevel.hashCode());
        result = prime * result + ((standardCost == null) ? 0 : standardCost.hashCode());
        result = prime * result + ((targetLevel == null) ? 0 : targetLevel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (category != other.category)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (discontinued == null) {
            if (other.discontinued != null)
                return false;
        } else if (!discontinued.equals(other.discontinued))
            return false;
        if (listPrice == null) {
            if (other.listPrice != null)
                return false;
        } else if (!listPrice.equals(other.listPrice))
            return false;
        if (minimumReorderQuantity == null) {
            if (other.minimumReorderQuantity != null)
                return false;
        } else if (!minimumReorderQuantity.equals(other.minimumReorderQuantity))
            return false;
        if (productCode == null) {
            if (other.productCode != null)
                return false;
        } else if (!productCode.equals(other.productCode))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (quantityPerUnit == null) {
            if (other.quantityPerUnit != null)
                return false;
        } else if (!quantityPerUnit.equals(other.quantityPerUnit))
            return false;
        if (reorderLevel == null) {
            if (other.reorderLevel != null)
                return false;
        } else if (!reorderLevel.equals(other.reorderLevel))
            return false;
        if (standardCost == null) {
            if (other.standardCost != null)
                return false;
        } else if (!standardCost.equals(other.standardCost))
            return false;
        if (targetLevel == null) {
            if (other.targetLevel != null)
                return false;
        } else if (!targetLevel.equals(other.targetLevel))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productCode=" + productCode + ", productName=" + productName + ", description=" + description
                + ", standardCost=" + standardCost + ", listPrice=" + listPrice + ", targetLevel=" + targetLevel + ", reorderLevel=" + reorderLevel
                + ", minimumReorderQuantity=" + minimumReorderQuantity + ", quantityPerUnit=" + quantityPerUnit + ", discontinued=" + discontinued
                + ", category=" + category + "]";
    }

    
}