package com.pizzashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class Ingredient {
    private Integer ingredientId;
    private String name;

    @JsonIgnore
    private Set<Pizza> pizzas;

    public Ingredient(){
        pizzas =new HashSet<>();
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredientId")
    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer idIngredient) {
        this.ingredientId = idIngredient;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    public Set<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(Set<Pizza> pizzaList) {
        this.pizzas = pizzaList;
    }


//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Ingredient that = (Ingredient) o;
//
//        if (ingredientId != null ? !ingredientId.equals(that.ingredientId) : that.ingredientId != null) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = ingredientId != null ? ingredientId.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
}
