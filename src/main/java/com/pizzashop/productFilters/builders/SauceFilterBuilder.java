package com.pizzashop.productFilters.builders;

import com.pizzashop.productFilters.SauceFilter;

import java.util.Set;

public class SauceFilterBuilder extends ProductFilterBuilder<SauceFilterBuilder>{
    private Set<String> seasonings;

    public SauceFilterBuilder setSeasonings(Set<String> seasonings) {
        this.seasonings = seasonings;
        return this;
    }

    public SauceFilter createSauceFilter() {
        return new SauceFilter(rebates, names, minPrice, maxPrice, seasonings);
    }
}