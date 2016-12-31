package com.pizzashop.repositories;

import com.pizzashop.models.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.pizzashop.repositories.DbInitializer.*;

/**
 * Created by barte on 30/12/2016.
 */
@Repository
public class InitEntitiesRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Set<Ingredient> ingredients;
    public Rebate rebate;
    public Pizza pizza;
    public Client client;
    public Order order;
    public Set<OrderPosition> orderPositions;
    public Complaint complaint;

    @Transactional
    public void st(){
        for (Ingredient ingredient: createIngredients()
             ) {
            entityManager.persist(ingredient);
        }

        for (Seasoning seasoning : createSeasonings()){
            entityManager.persist(seasoning);
        }

        rebate=createRebate();
        entityManager.persist(rebate);

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
    public void next(){
        Ingredient i1 = new ArrayList<>(ingredients).get(0);
        i1= entityManager.merge(i1);
        ingredients=new HashSet<>();
        ingredients.add(i1);
        rebate=entityManager.merge(rebate);
        pizza=createPizza(ingredients,rebate);

        entityManager.persist(pizza);
    }

    @Transactional
    public void next2(){
        ingredients=createIngredients();
        Set<Ingredient> merged=new HashSet<>();

        for (Ingredient ingredient:ingredients
             ) {
            merged.add(entityManager.merge(ingredient));
        }

        rebate=createRebate();
        rebate=entityManager.merge(rebate);

        pizza=createPizza(merged,rebate);

        entityManager.persist(pizza);
    }
}
