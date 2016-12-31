package com.pizzashop.repositories;

import com.pizzashop.models.Drink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by barte on 09/12/2016.
 */
@Transactional
public interface DrinkRepository extends ProductBaseRepository<Drink>,JpaSpecificationExecutor<Drink> {
    Page<Drink> findAll(Pageable pageRequest);

    @Query("SELECT distinct product.name FROM Product product")
    List<String> findNames();
}
