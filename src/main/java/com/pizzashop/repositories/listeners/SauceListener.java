package com.pizzashop.repositories.listeners;

import com.pizzashop.models.Sauce;
import com.pizzashop.productFilters.SauceFilter;
import com.pizzashop.repositories.initializers.ProductFilterInitializer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;

/**
 * Created by barte on 31/12/2016.
 */
public class SauceListener {
    @Autowired
    SauceFilter sauceFilter;

    @Autowired
    ProductFilterInitializer productFilterInitializer;

    @PostPersist
    public void saucePostPersist(Sauce sauce){
        productFilterInitializer.updateSauceFilter(sauceFilter);
    }
}
