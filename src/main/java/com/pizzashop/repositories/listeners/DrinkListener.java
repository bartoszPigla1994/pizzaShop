package com.pizzashop.repositories.listeners;

import com.pizzashop.models.Drink;
import com.pizzashop.productFilters.DrinkFilter;
import com.pizzashop.repositories.initializers.ProductFilterInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;

/**
 * Created by barte on 31/12/2016.
 */
public class DrinkListener {
    @Autowired
    DrinkFilter drinkFilter;

    @Autowired
    ProductFilterInitializer productFilterInitializer;

    @PostPersist
    public void drinkPostPersist(Drink drink){
        productFilterInitializer.updateDrinkFilter(drinkFilter);
    }
}
