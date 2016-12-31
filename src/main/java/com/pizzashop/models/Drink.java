package com.pizzashop.models;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "productId")
public class Drink extends Product  implements Serializable {
    @NotNull    @Length(max=10)
    private String literCount;

    public Drink(
            String name,
            String description,
            BigDecimal price,
            Set<Rebate> rebates,
            String literCount){
        super(name,description,price,rebates);
        this.literCount=literCount;
    }

    public Drink(){}

    @Basic
    @Column(name = "literCount")
    public String getLiterCount() {
        return literCount;
    }

    public void setLiterCount(String literCount) {
        this.literCount = literCount;
    }
}
