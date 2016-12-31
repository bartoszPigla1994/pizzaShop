package com.pizzashop.repositories.initializers;

import com.pizzashop.models.*;
import com.pizzashop.models.enums.DoughType;
import com.pizzashop.models.interfaces.Nameable;
import com.pizzashop.productFilters.DrinkFilter;
import com.pizzashop.productFilters.PizzaFilter;
import com.pizzashop.productFilters.SauceFilter;
import com.pizzashop.productFilters.builders.DrinkFilterBuilder;
import com.pizzashop.productFilters.builders.PizzaFilterBuilder;
import com.pizzashop.productFilters.builders.SauceFilterBuilder;
import com.pizzashop.repositories.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
public class ProductFilterInitializer {
    @Autowired
    FilterRepository filterRepository;
//    @Autowired
//    PizzaRepository pizzaRepository;
//
//    @Autowired
//    SauceRepository sauceRepository;
//
//    @Autowired
//    DrinkRepository drinkRepository;
//
//    @Autowired
//    IngredientRepository ingredientRepository;
//
//    @Autowired
//    SeasoningRepository seasoningRepository;
//
//    @Autowired
//    RebateRepository rebateRepository;
//
//    <T extends ProductFilterBuilder> ProductFilterBuilder createProductFilter(ProductFilterBuilder<T> productFilterBuilder, INames productNames, INames rebateNames){
//        return (T) productFilterBuilder
//                .setRebates(getNames(rebateNames))
//                .setNames(getNames(productNames));
//
//    }

    public <T extends Nameable> Set<String> getNames(Class<T> cl){
        return filterRepository.getNames(cl);
    }

    public PizzaFilter createPizzaFilter() {
        return new PizzaFilterBuilder()
                .setNames(getNames(Pizza.class))
                .setRebates(getNames(Rebate.class))
                .setDoughTypes(DoughType.names())
                .setIngredients(getNames(Ingredient.class))
                .createPizzaFilter();
    }

    public SauceFilter createSauceFilter() {
        return new SauceFilterBuilder()
                .setNames(getNames(Sauce.class))
                .setRebates(getNames(Rebate.class))
                .setSeasonings(getNames(Seasoning.class))
                .createSauceFilter();
    }

    public DrinkFilter createDrinkFilter() {
        return new DrinkFilterBuilder()
                .setNames(getNames(Drink.class))
                .setRebates(getNames(Rebate.class))
                .setLiterCounts(filterRepository.getLiterCounts())
                .createDrinkFilter();
    }

//    public PizzaFilter createPizzaFilter() {
//        return new PizzaFilterBuilder()
//                .setNames(getNames(sauceRepository.findNames()))
//                .setRebates(getNames(rebateRepository.findNames()))
//                .setDoughTypes(DoughType.names())
//                .setIngredients(getNames(ingredientRepository.findNames()))
//                .createPizzaFilter();
//    }
//
//    public SauceFilter createSauceFilter() {
//        return new SauceFilterBuilder()
//                .setNames(getNames(sauceRepository.findNames()))
//                .setRebates(getNames(rebateRepository.findNames()))
//                .setSeasonings(getNames(seasoningRepository.findNames()))
//                .createSauceFilter();
//    }
//
//    public DrinkFilter createDrinkFilter() {
//        return new DrinkFilterBuilder()
//                .setNames(getNames(drinkRepository.findNames()))
//                .setRebates(getNames(rebateRepository.findNames()))
//                .setLiterCounts(getNames(drinkRepository.findNames()))
//                .createDrinkFilter();
//    }
//
//    Set<String> getNames(List<String> names) {
//        //List<Nameable> list = repository.findAll()
//        return new HashSet<>(names);
//    }


    public void updatePizzaFilter(PizzaFilter pizzaFilter) {
        PizzaFilter newPizzaFilter=createPizzaFilter();

        pizzaFilter.setDoughTypes(newPizzaFilter.getDoughTypes());
        pizzaFilter.setIngredients(newPizzaFilter.getIngredients());
        pizzaFilter.setNames(newPizzaFilter.getNames());
        pizzaFilter.setRebates(newPizzaFilter.getRebates());
    }

    public void updateDrinkFilter(DrinkFilter drinkFilter) {
        DrinkFilter newDrinkFilter=createDrinkFilter();

        drinkFilter.setNames(newDrinkFilter.getNames());
        drinkFilter.setRebates(newDrinkFilter.getRebates());
        drinkFilter.setLiterCounts(newDrinkFilter.getLiterCounts());
    }

    public void updateSauceFilter(SauceFilter sauceFilter){
        SauceFilter newSauceFilter=createSauceFilter();

        sauceFilter.setNames(newSauceFilter.getNames());
        sauceFilter.setRebates(newSauceFilter.getRebates());
        sauceFilter.setSeasonings(newSauceFilter.getSeasonings());
    }

}
