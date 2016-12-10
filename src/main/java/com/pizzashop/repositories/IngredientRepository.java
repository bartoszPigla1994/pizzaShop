package com.pizzashop.repositories;

import com.pizzashop.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by barte on 09/12/2016.
 */
@Transactional
public interface IngredientRepository  extends JpaRepository<Ingredient,Integer>{
    Ingredient findIngredientByName(String name);
}
