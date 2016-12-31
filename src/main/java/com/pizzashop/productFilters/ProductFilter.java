package com.pizzashop.productFilters;

import com.pizzashop.annotations.Price;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
public abstract class ProductFilter {
    @NotEmpty
    protected Set<String> rebates;

    @NotEmpty
    protected Set<String> names;

    @NotNull
    @Price
    protected BigDecimal minPrice, maxPrice;

    public ProductFilter(Set<String> rebates, Set<String> names, BigDecimal minPrice, BigDecimal maxPrice) {
        this.rebates = rebates;
        this.names = names;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public ProductFilter() {
    }

    public Set<String> getRebates() {
        return rebates;
    }

    public void setRebates(Set<String> rebates) {
        this.rebates = rebates;
    }

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
