package com;

import com.pizzashop.PizzaShopApplication;
import com.pizzashop.exceptions.IngredientNotFoundException;
import com.pizzashop.exceptions.RebateNotFoundException;
import com.pizzashop.models.Pizza;
import com.pizzashop.productFilters.PizzaFilter;
import com.pizzashop.repositories.IngredientRepository;
import com.pizzashop.repositories.PizzaRepository;
import com.pizzashop.repositories.ProductRepository;
import com.pizzashop.repositories.RebateRepository;
import com.pizzashop.repositories.initializers.InitEntitiesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.TestHelper.compareNotOrderedCollections;
import static com.pizzashop.repositories.initializers.DbInitializer.createPizza;

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
    RebateRepository rebateRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    InitEntitiesRepository initEntitiesRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void pizzaFilterIngredientsTest() {
        Set<String> ingredients = ingredientRepository.findAll().stream().map(ingredient -> ingredient.getName()).collect(Collectors.toSet());

        compareNotOrderedCollections(ingredients,pizzaFilter.getIngredients());
    }

    @Test
    public void pizzaFilterRebatesTest() {
        Set<String> rebates = rebateRepository.findAll().stream().map(rebate -> rebate.getName()).collect(Collectors.toSet());

        compareNotOrderedCollections(rebates,pizzaFilter.getRebates());
    }

    @Test
    public void pizzaFilterNamesTest(){
        Set<String> names = pizzaRepository.findAll().stream().map(pizza -> pizza.getName()).collect(Collectors.toSet());

        compareNotOrderedCollections(names, pizzaFilter.getNames());
    }

    @Test
    public void addsNewValuesToFilter(){
        //initEntitiesRepository.initializePizza();
        Pizza pizza1 = createPizza(new HashSet<>(ingredientRepository.findAll()),rebateRepository.findAll().get(0));
        pizza1.setName("nowaPizza");
        try {
            productRepository.save(pizza1);
        } catch (IngredientNotFoundException e) {
            e.printStackTrace();
        } catch (RebateNotFoundException e) {
            e.printStackTrace();
        }

        pizzaFilterNamesTest();
    }


}
