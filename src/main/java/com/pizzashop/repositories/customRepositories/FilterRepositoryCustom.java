package com.pizzashop.repositories.customRepositories;

import com.pizzashop.models.interfaces.Nameable;

import java.util.Set;

/**
 * Created by barte on 31/12/2016.
 */
public interface FilterRepositoryCustom {
    <T extends Nameable> Set<String> getNames(Class<T> tClass);

    Set<String> getLiterCounts();
}

