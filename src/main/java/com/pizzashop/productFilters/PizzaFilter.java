package com.pizzashop.productFilters;

import com.pizzashop.annotations.Price;
import com.pizzashop.models.enums.DoughType;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
public class PizzaFilter extends ProductFilter {
    @NotEmpty
    protected Set<String> ingredients;

    @NotNull
    @Price
    protected BigDecimal doughMinPrice, doughMaxPrice;

    @NotEmpty
    protected Set<DoughType> doughType;

    public PizzaFilter(Set<String> rebates, Set<String> names, BigDecimal minPrice, BigDecimal maxPrice, Set<String> ingredients, BigDecimal doughMinPrice, BigDecimal doughMaxPrice, Set<DoughType> doughType) {
        super(rebates, names, minPrice, maxPrice);
        this.ingredients = ingredients;
        this.doughMinPrice = doughMinPrice;
        this.doughMaxPrice = doughMaxPrice;
        this.doughType = doughType;
    }

    public PizzaFilter(Set<String> ingredients, BigDecimal doughMinPrice, BigDecimal doughMaxPrice, Set<DoughType> doughType) {
        this.ingredients = ingredients;
        this.doughMinPrice = doughMinPrice;
        this.doughMaxPrice = doughMaxPrice;
        this.doughType = doughType;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<String> ingredients) {
        this.ingredients = ingredients;
    }

    public BigDecimal getDoughMinPrice() {
        return doughMinPrice;
    }

    public void setDoughMinPrice(BigDecimal doughMinPrice) {
        this.doughMinPrice = doughMinPrice;
    }

    public BigDecimal getDoughMaxPrice() {
        return doughMaxPrice;
    }

    public void setDoughMaxPrice(BigDecimal doughMaxPrice) {
        this.doughMaxPrice = doughMaxPrice;
    }

    public Set<DoughType> getDoughType() {
        return doughType;
    }

    public void setDoughType(Set<DoughType> doughType) {
        this.doughType = doughType;
    }
}
