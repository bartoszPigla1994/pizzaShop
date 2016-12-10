package com.pizzashop.repositories;

import com.pizzashop.models.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by barte on 08/12/2016.
 */
@Transactional
public interface PizzaRepository extends ProductBaseRepository<Pizza>,JpaSpecificationExecutor<Pizza> {
    Page<Pizza> findAll(Pageable pageRequest);
}
