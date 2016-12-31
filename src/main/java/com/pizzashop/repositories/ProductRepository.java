package com.pizzashop.repositories;

import com.pizzashop.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by barte on 09/12/2016.
 */
@Transactional
public interface ProductRepository extends ProductBaseRepository<Product>,ProductRepositoryCustom{
    Page<Product> findAll(Pageable pageRequest);
}