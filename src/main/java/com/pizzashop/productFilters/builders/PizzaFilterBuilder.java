package com.pizzashop.productFilters.builders;

import com.pizzashop.productFilters.PizzaFilter;

import java.math.BigDecimal;
import java.util.Set;

public class PizzaFilterBuilder extends ProductFilterBuilder<PizzaFilterBuilder>{
    private Set<String> ingredients;
    private BigDecimal doughMinPrice;
    private BigDecimal doughMaxPrice;
    private Set<String> doughTypes;


    public PizzaFilterBuilder setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public PizzaFilterBuilder setDoughMinPrice(BigDecimal doughMinPrice) {
        this.doughMinPrice = doughMinPrice;
        return this;
    }

    public PizzaFilterBuilder setDoughMaxPrice(BigDecimal doughMaxPrice) {
        this.doughMaxPrice = doughMaxPrice;
        return this;
    }

    public PizzaFilterBuilder setDoughTypes(Set<String> doughTypes) {
        this.doughTypes = doughTypes;
        return this;
    }

    public PizzaFilter createPizzaFilter() {
        return new PizzaFilter(rebates, names, minPrice, maxPrice, ingredients, doughMinPrice, doughMaxPrice, doughTypes);
    }
//
//    public PizzaFilter update(PizzaFilter pizzaFilter){
//        PizzaFilter pizzaFilter = (PizzaFilter) super.update(pizzaFilter);
//    }
}