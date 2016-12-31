package com.pizzashop.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class Seasoning  implements Serializable {
    private Integer seasoningId;
    private String name;

    public Seasoning(String name) {
        this.name = name;
    }

    public Seasoning() {
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "seasoningId")
    public Integer getSeasoningId() {
        return seasoningId;
    }

    public void setSeasoningId(Integer idSeasonings) {
        this.seasoningId = idSeasonings;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seasoning seasoning = (Seasoning) o;
        return Objects.equals(name, seasoning.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
