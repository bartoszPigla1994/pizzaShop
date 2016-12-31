package com.pizzashop.models.builders;

import com.pizzashop.models.Rebate;
import com.pizzashop.models.Sauce;
import com.pizzashop.models.Seasoning;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SauceBuilder {
    private String name;
    private String description;
    private BigDecimal price;
    private Set<Rebate> rebates;
    private Set<Seasoning> seasonings;

    public SauceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SauceBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public SauceBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public SauceBuilder setRebates(Set<Rebate> rebates) {
        this.rebates = rebates;
        return this;
    }

    public SauceBuilder setSeasonings(Set<Seasoning> seasonings) {
        this.seasonings = seasonings;
        return this;
    }

    public SauceBuilder addRebates(Rebate... rebates) {
        this.rebates = new HashSet<>(Arrays.asList(rebates));
        return this;
    }

    public SauceBuilder addSeasonings(Seasoning... seasonings) {
        this.seasonings = new HashSet<>(Arrays.asList(seasonings));
        return this;
    }

    public Sauce createSauce() {
        return new Sauce(name, description, price, rebates, seasonings);
    }
}