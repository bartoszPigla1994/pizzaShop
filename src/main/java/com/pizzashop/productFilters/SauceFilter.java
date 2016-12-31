package com.pizzashop.productFilters;

import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
public class SauceFilter extends ProductFilter {
    @NotEmpty
    protected Set<String> seasonings;

    public SauceFilter(Set<String> rebates, Set<String> names, BigDecimal minPrice, BigDecimal maxPrice, Set<String> seasonings) {
        super(rebates, names, minPrice, maxPrice);
        this.seasonings = seasonings;
    }

    public Set<String> getSeasonings() {
        return seasonings;
    }

    public void setSeasonings(Set<String> seasonings) {
        this.seasonings = seasonings;
    }
}
