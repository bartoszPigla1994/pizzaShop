package com.pizzashop.repositories;

import com.pizzashop.exceptions.IngredientNotFoundException;
import com.pizzashop.exceptions.RebateNotFoundException;
import com.pizzashop.exceptions.SeasoningNotFoundException;
import com.pizzashop.models.Drink;
import com.pizzashop.models.Pizza;
import com.pizzashop.models.Sauce;

/**
 * Created by barte on 30/12/2016.
 */
public interface ProductRepositoryCustom {
    Pizza save(Pizza pizza) throws IngredientNotFoundException, RebateNotFoundException;
    Sauce save(Sauce sauce) throws SeasoningNotFoundException, RebateNotFoundException;
    Drink save(Drink drink) throws RebateNotFoundException;
}
