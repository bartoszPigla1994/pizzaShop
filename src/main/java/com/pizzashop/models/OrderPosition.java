package com.pizzashop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class OrderPosition {
    private Integer orderPositionId;
    private Integer count;
    private BigDecimal price;
    @JsonIgnore
    private ProductOrder productOrder;
    private Product product;
    private Rebate rebate;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderPositionId")
    public Integer getOrderPositionId() {
        return orderPositionId;
    }

    public void setOrderPositionId(Integer orderPositionId) {
        this.orderPositionId = orderPositionId;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductOrder_productOrderId", referencedColumnName = "productOrderId", nullable = false)
    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="productId")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="rebateId")
    public Rebate getRebate() {
        return rebate;
    }

    public void setRebate(Rebate rebate) {
        this.rebate = rebate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPosition that = (OrderPosition) o;

        if (orderPositionId != null ? !orderPositionId.equals(that.orderPositionId) : that.orderPositionId != null)
            return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (productOrder != null ? !productOrder.equals(that.productOrder) : that.productOrder != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return rebate != null ? rebate.equals(that.rebate) : that.rebate == null;

    }

    @Override
    public int hashCode() {
        int result = orderPositionId != null ? orderPositionId.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (productOrder != null ? productOrder.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (rebate != null ? rebate.hashCode() : 0);
        return result;
    }
}
