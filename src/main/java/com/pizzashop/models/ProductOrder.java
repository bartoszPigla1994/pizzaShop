package com.pizzashop.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class ProductOrder {
    private Integer productOrderId;
    private Date orderDate;
    private String address;
    private Date receiptDate;
    private BigDecimal price;
    private Client client;

    @Enumerated(EnumType.STRING)
    private ProductOrderStatus productOrderStatus;

    private Set<OrderPosition> orderPositions;

    public ProductOrder(){
        orderPositions =new HashSet<>();
    }

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productOrderId")
    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    @Basic
    @Column(name = "orderDate")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "receiptDate")
    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @OneToMany(mappedBy = "productOrder", fetch = FetchType.EAGER)
    public Set<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(Set<OrderPosition> orderPositionsList) {
        this.orderPositions = orderPositionsList;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Client_clientId", referencedColumnName = "clientId", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addOrderPosition(OrderPosition position){
        orderPositions.add(position);
    }

    @Basic
    @Column(name = "productOrderStatus")
    public ProductOrderStatus getProductOrderStatus() {
        return productOrderStatus;
    }

    public void setProductOrderStatus(ProductOrderStatus productOrderStatus) {
        this.productOrderStatus = productOrderStatus;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        ProductOrder that = (ProductOrder) o;
//
//        if (productOrderId != null ? !productOrderId.equals(that.productOrderId) : that.productOrderId != null)
//            return false;
//        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
//        if (address != null ? !address.equals(that.address) : that.address != null) return false;
//        if (receiptDate != null ? !receiptDate.equals(that.receiptDate) : that.receiptDate != null) return false;
//        if (price != null ? !price.equals(that.price) : that.price != null) return false;
//        if (client != null ? !client.equals(that.client) : that.client != null) return false;
//        if (productOrderStatus != that.productOrderStatus) return false;
//        return orderPositions != null ? orderPositions.equals(that.orderPositions) : that.orderPositions == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = productOrderId != null ? productOrderId.hashCode() : 0;
//        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
//        result = 31 * result + (address != null ? address.hashCode() : 0);
//        result = 31 * result + (receiptDate != null ? receiptDate.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        result = 31 * result + (client != null ? client.hashCode() : 0);
//        result = 31 * result + (productOrderStatus != null ? productOrderStatus.hashCode() : 0);
//        result = 31 * result + (orderPositions != null ? orderPositions.hashCode() : 0);
//        return result;
//    }
}
