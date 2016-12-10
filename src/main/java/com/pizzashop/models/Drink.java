package com.pizzashop.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
@PrimaryKeyJoinColumn(name = "productId")
public class Drink extends Product {
    private String literCount;
    @Basic
    @Column(name = "literCount")
    public String getLiterCount() {
        return literCount;
    }

    public void setLiterCount(String literCount) {
        this.literCount = literCount;
    }


}
