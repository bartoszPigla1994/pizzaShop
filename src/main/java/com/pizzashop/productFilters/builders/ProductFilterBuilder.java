package com.pizzashop.productFilters.builders;

import java.math.BigDecimal;
import java.util.Set;

public class ProductFilterBuilder<T> {
    protected Set<String> rebates;
    protected Set<String> names;
    protected BigDecimal minPrice;
    protected BigDecimal maxPrice;

    public T setRebates(Set<String> rebates) {
        this.rebates = rebates;
        return (T)this;
    }

    public T setNames(Set<String> names) {
        this.names = names;
        return (T)this;
    }

    public T setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return (T)this;
    }

    public T setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return (T)this;
    }

//    protected ProductFilter update(ProductFilter productFilter){
//        productFilter.setRebates(rebates);
//        productFilter.setNames(names);
//        return productFilter;
//    }
}