package com.pizzashop.models;

import javax.persistence.*;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class Seasoning {
    private Integer seasoningId;
    private String name;

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
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Seasoning that = (Seasoning) o;
//
//        if (seasoningId != null ? !seasoningId.equals(that.seasoningId) : that.seasoningId != null) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = seasoningId != null ? seasoningId.hashCode() : 0;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
//    }
}
