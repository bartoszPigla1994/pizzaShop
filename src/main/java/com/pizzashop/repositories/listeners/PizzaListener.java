package com.pizzashop.repositories.listeners;

import com.pizzashop.models.Pizza;
import com.pizzashop.productFilters.PizzaFilter;
import com.pizzashop.repositories.initializers.ProductFilterInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;

/**
 * Created by barte on 31/12/2016.
 */
public class PizzaListener {
    @Autowired
    PizzaFilter pizzaFilter;

    @Autowired
    ProductFilterInitializer productFilterInitializer;

    @PostPersist
    public void pizzaPostPersist(Pizza pizza){
        productFilterInitializer.updatePizzaFilter(pizzaFilter);
    }
}
