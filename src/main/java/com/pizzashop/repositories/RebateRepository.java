package com.pizzashop.repositories;

import com.pizzashop.models.Rebate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by barte on 10/12/2016.
 */
@Transactional
public interface RebateRepository extends JpaRepository<Rebate,Integer>{
}
