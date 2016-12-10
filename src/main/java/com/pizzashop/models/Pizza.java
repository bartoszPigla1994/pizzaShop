package com.pizzashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "productId")
public class Pizza extends Product{
    private String doughType;
    private BigDecimal doughPrice;

    private Set<Ingredient> ingredients;

    public Pizza(){
        ingredients=new HashSet<>();
    }

    @Basic
    @Column(name = "doughType")
    public String getDoughType() {
        return doughType;
    }

    public void setDoughType(String doughType) {
        this.doughType = doughType;
    }

    @Basic
    @Column(name = "doughPrice")
    public BigDecimal getDoughPrice() {
        return doughPrice;
    }

    public void setDoughPrice(BigDecimal doughPrice) {
        this.doughPrice = doughPrice;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PizzaIngredient",
            joinColumns = @JoinColumn(name = "pizzaId", referencedColumnName = "productId"),
            inverseJoinColumns = @JoinColumn(name = "ingredientId", referencedColumnName = "ingredientId")
    )
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }


}
