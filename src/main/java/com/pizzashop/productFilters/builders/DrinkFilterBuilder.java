package com.pizzashop.productFilters.builders;

import com.pizzashop.productFilters.DrinkFilter;

import java.util.Set;

public class DrinkFilterBuilder extends ProductFilterBuilder<DrinkFilterBuilder>{

    private Set<String> literCounts;

    public DrinkFilterBuilder setLiterCounts(Set<String> literCounts) {
        this.literCounts = literCounts;
        return this;
    }

    public DrinkFilter createDrinkFilter() {
        return new DrinkFilter(rebates, names, minPrice, maxPrice, literCounts);
    }

}