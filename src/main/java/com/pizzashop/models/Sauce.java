package com.pizzashop.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "productId")
public class Sauce extends Product{
    private Set<Seasoning> seasonings;

    public Sauce(){
        seasonings =new HashSet<>();
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "SauceSeasonings",
            joinColumns = @JoinColumn(name = "sauceId", referencedColumnName = "productId"),
            inverseJoinColumns = @JoinColumn(name = "seasoningId", referencedColumnName = "seasoningId")
    )
    public Set<Seasoning> getSeasonings() {
        return seasonings;
    }

    public void setSeasonings(Set<Seasoning> seasonings) {
        this.seasonings = seasonings;
    }

    public void addSeasoning(Seasoning seasoning){
        seasonings.add(seasoning);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sauce sauce = (Sauce) o;

        return seasonings != null ? seasonings.equals(sauce.seasonings) : sauce.seasonings == null;

    }

    @Override
    public int hashCode() {
        return seasonings != null ? seasonings.hashCode() : 0;
    }
}
