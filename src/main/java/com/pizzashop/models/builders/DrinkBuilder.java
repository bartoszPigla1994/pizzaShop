package com.pizzashop.models.builders;

import com.pizzashop.models.Drink;
import com.pizzashop.models.Rebate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DrinkBuilder {
    private String name;
    private String description;
    private BigDecimal price;
    private Set<Rebate> rebates;
    private String literCount;

    public DrinkBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public DrinkBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public DrinkBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public DrinkBuilder setRebates(Set<Rebate> rebates) {
        this.rebates = rebates;
        return this;
    }

    public DrinkBuilder setLiterCount(String literCount) {
        this.literCount = literCount;
        return this;
    }

    public Drink createDrink() {
        return new Drink(name, description, price, rebates, literCount);
    }

    public DrinkBuilder addRebates(Rebate... rebate) {
        this.rebates=new HashSet<>(Arrays.asList(rebate));
        return this;
    }
}