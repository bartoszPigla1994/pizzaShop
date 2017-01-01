package com.pizzashop.specifications;

import com.pizzashop.models.Seasoning;
import com.pizzashop.productFilters.SauceFilter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by barte on 01/01/2017.
 */
public class SauceSpecification<T> extends ProductSpecification<T> {
    public SauceSpecification(SauceFilter sauceFilter) {
        super(sauceFilter);
    }

    @Override
    public Predicate toPredicate(Root<T> sauce, CriteriaQuery<?> query, CriteriaBuilder cb) {
        SauceFilter sauceFilter = (SauceFilter) productFilter;

        List<Seasoning> seasonings=sauceFilter.getSeasonings();

        Predicate predicate = super.toPredicate(sauce,query,cb);

        if(predicate == null)
            predicate=cb.conjunction();

        for (Seasoning seasoning:seasonings
                ) {
            predicate = cb.and(predicate, cb.isMember(seasoning,sauce.get("seasonings")));
        }
        return predicate;
    }
}
