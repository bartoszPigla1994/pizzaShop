package com;

import com.pizzashop.PizzaShopApplication;
import com.pizzashop.productFilters.PizzaFilter;
import com.pizzashop.repositories.IngredientRepository;
import com.pizzashop.repositories.PizzaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by barte on 31/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzaShopApplication.class)
@WebAppConfiguration
public class ProductFilterTest {
    @Autowired
    PizzaFilter pizzaFilter;

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @Test
    public void pizzaFilterTest() {
        Set<String> ingredients = ingredientRepository.findAll().stream().map(ingredient -> ingredient.getName()).collect(Collectors.toSet());
        Assert.assertTrue(ingredients.containsAll(pizzaFilter.getIngredients())
                && pizzaFilter.getIngredients().containsAll(ingredients));

    }
}
