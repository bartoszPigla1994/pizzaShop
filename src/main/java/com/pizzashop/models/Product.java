package com.pizzashop.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Product {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Set<Rebate> rebates;
//    @Enumerated(EnumType.STRING)
//    private ProductType type;
    public Product(){
        rebates=new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
//
//    @Basic
//    @Column(name = "type")
//    public ProductType getType() {
//        return type;
//    }
//
//    public void setType(ProductType type) {
//        this.type = type;
//    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ProductRebate",
            joinColumns = @JoinColumn(name = "productId", referencedColumnName = "productId"),
            inverseJoinColumns = @JoinColumn(name = "rebateId", referencedColumnName = "rebateId")
    )
    public Set<Rebate> getRebates() {
        return rebates;
    }

    public void setRebates(Set<Rebate> rebates) {
        this.rebates = rebates;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Product product = (Product) o;
//
//        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
//        if (name != null ? !name.equals(product.name) : product.name != null) return false;
//        if (description != null ? !description.equals(product.description) : product.description != null) return false;
//        if (price != null ? !price.equals(product.price) : product.price != null) return false;
//        return rebates != null ? rebates.equals(product.rebates) : product.rebates == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = productId != null ? productId.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        result = 31 * result + (rebates != null ? rebates.hashCode() : 0);
//        return result;
//    }

    public void addRebate(Rebate rebate) {
        rebates.add(rebate);
    }
}
