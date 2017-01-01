package com.pizzashop.repositories.initializers;

import com.pizzashop.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.pizzashop.repositories.initializers.DbInitializer.createPizza;
import static com.pizzashop.repositories.initializers.DbInitializer.createRebate;

/**
 * Created by barte on 30/12/2016.
 */
@Repository
public class InitEntitiesRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Set<Ingredient> ingredients = new HashSet<>();
    public Set<Seasoning> seasonings= new HashSet<>();
    public Rebate rebate;
    public Pizza pizza;
    public Client client;
    public Order order;
    public Set<OrderPosition> orderPositions= new HashSet<>();
    public Complaint complaint;

    @Transactional
    public void initializeProductSubComponents(){
        Cache cache = entityManager.getEntityManagerFactory().getCache();

        for (Ingredient ingredient: DbInitializer.createIngredients()
             ) {
            //System.out.println("before persist: "+cache.contains(Ingredient.class, ingredient.getIngredientId()));

            entityManager.persist(ingredient);
            //cache.

            //System.out.println("after persist: "+cache.contains(Ingredient.class, ingredient.getIngredientId()));

            entityManager.flush();
                       ingredients.add(ingredient);
        }




        for (Seasoning seasoning : DbInitializer.createSeasonings()){
            entityManager.persist(seasoning);
            seasonings.add(seasoning);
        }

        rebate= createRebate();
        entityManager.persist(rebate);




        pizza=createPizza(ingredients,rebate);

        entityManager.persist(pizza);

        entityManager.flush();

//        rebate=createRebate();
//
//        pizza=createPizza(ingredients,rebate);
//
//        entityManager.persist(pizza);
//
//        client=createClient();
//        order=createOrder(client);
//        orderPositions=createOrderPositions(order, pizza,rebate);
//
//        entityManager.persist(order);
//
//        complaint=createComplaint(order);
//
//        entityManager.persist(complaint);

    }

    @Transactional
    public void initializePizza(){
        Set<Ingredient> persistedIngredients = new HashSet<>();
        for (Ingredient ingredient: ingredients){
            persistedIngredients.add(entityManager.merge(ingredient));
        }

        rebate = entityManager.merge(rebate);

        pizza = createPizza(persistedIngredients, rebate);

        entityManager.persist(pizza);
        entityManager.flush();
    }

    @Transactional
    public void next(){
        Ingredient i1 = new ArrayList<>(ingredients).get(0);
        i1= entityManager.merge(i1);
        ingredients=new HashSet<>();
        ingredients.add(i1);
        rebate=entityManager.merge(rebate);
        pizza= createPizza(ingredients,rebate);

        entityManager.persist(pizza);
    }

    @Transactional
    public void next2(){
        ingredients= DbInitializer.createIngredients();
        Set<Ingredient> merged=new HashSet<>();

        for (Ingredient ingredient:ingredients
             ) {
            merged.add(entityManager.merge(ingredient));
        }

        rebate= createRebate();
        rebate=entityManager.merge(rebate);

        pizza= createPizza(merged,rebate);

        entityManager.persist(pizza);
    }
}
