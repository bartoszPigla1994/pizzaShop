package com.pizzashop.models;

import com.pizzashop.annotations.Price;
import com.pizzashop.models.interfaces.Nameable;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product implements Serializable, Nameable {
    private Integer productId;
    @NotNull
    @Length(max = 30)
    private String name;
    @NotNull
    @Length(max = 255)
    private String description;
    @NotNull
    @Price
    private BigDecimal price;
    @NotEmpty
    private Set<Rebate> rebates = new HashSet<>();

    public Product() {
    }

    public Product(
            String name,
            String description,
            BigDecimal price,
            Set<Rebate> rebates
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.rebates = rebates;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", updatable = false, nullable = false)
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

    public void addRebate(Rebate rebate) {
        rebates.add(rebate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
