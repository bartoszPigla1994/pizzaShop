package com.pizzashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by barte on 10/12/2016.
 */
@Entity
public class Rebate {
    private Integer rebateId;
    private String name;

    @JsonIgnore
    private Set<Product> products;

    public Rebate(){
        products=new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rebateId")
    public Integer getRebateId() {
        return rebateId;
    }

    public void setRebateId(Integer rebateId) {
        this.rebateId = rebateId;
    }
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "rebates", fetch = FetchType.LAZY)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Rebate rebate = (Rebate) o;
//
//        if (rebateId != null ? !rebateId.equals(rebate.rebateId) : rebate.rebateId != null) return false;
//        if (name != null ? !name.equals(rebate.name) : rebate.name != null) return false;
//        return products != null ? products.equals(rebate.products) : rebate.products == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = rebateId != null ? rebateId.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (products != null ? products.hashCode() : 0);
//        return result;
//    }
}
