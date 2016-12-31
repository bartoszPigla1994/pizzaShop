package com.pizzashop.repositories.customRepositories;

import com.pizzashop.models.interfaces.Nameable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
@Repository
@Transactional
public class FilterRepositoryImpl implements FilterRepositoryCustom{
    @PersistenceContext
    EntityManager entityManager;

    public <T extends Nameable> Set<String> getNames(Class<T> tClass) {
        Query query = entityManager.createQuery("select distinct entity.name from "+tClass.getName()+" entity ");
        return new HashSet<>(query.getResultList());
    }

    public Set<String> getLiterCounts(){
        Query query = entityManager.createQuery("select distinct drink.literCount from Drink drink");
        return new HashSet<>(query.getResultList());
    }
}
