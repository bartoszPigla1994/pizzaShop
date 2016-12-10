package com.pizzashop.repositories;

import com.pizzashop.models.Seasoning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by barte on 09/12/2016.
 */
@Transactional
public interface SeasoningRepository extends JpaRepository<Seasoning,Integer>{
}
