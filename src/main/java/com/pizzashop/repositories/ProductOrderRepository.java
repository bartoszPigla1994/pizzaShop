package com.pizzashop.repositories;

import com.pizzashop.models.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by barte on 10/12/2016.
 */
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer>{
}
