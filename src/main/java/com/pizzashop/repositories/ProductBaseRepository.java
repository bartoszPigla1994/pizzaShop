package com.pizzashop.repositories;

import com.pizzashop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by barte on 09/12/2016.
 */
@NoRepositoryBean
public interface ProductBaseRepository<T extends Product> extends JpaRepository<T, Integer> {
}
