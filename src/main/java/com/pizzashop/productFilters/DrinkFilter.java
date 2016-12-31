package com.pizzashop.productFilters;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
public class DrinkFilter extends ProductFilter {
    protected Set<String> literCounts;

    public DrinkFilter(Set<String> rebates, Set<String> names, BigDecimal minPrice, BigDecimal maxPrice, Set<String> literCounts) {
        super(rebates, names, minPrice, maxPrice);
        this.literCounts = literCounts;
    }

    public DrinkFilter(Set<String> literCounts) {
        this.literCounts = literCounts;
    }

    public Set<String> getLiterCounts() {
        return literCounts;
    }

    public void setLiterCounts(Set<String> literCounts) {
        this.literCounts = literCounts;
    }
}
