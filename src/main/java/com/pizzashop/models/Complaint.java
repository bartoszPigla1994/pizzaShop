package com.pizzashop.models;

import com.pizzashop.models.enums.ComplaintStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class Complaint  implements Serializable {
    private Integer complaintId;
    private Date submitDate;
    private String comment;
    private Order order;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus complaintStatus;

    public Complaint(Date submitDate, String comment, Order order, ComplaintStatus complaintStatus) {
        this.submitDate = submitDate;
        this.comment = comment;
        this.order = order;
        this.complaintStatus = complaintStatus;
    }

    public Complaint() {
    }

    @Id    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "complaintId")
    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    @Basic
    @Column(name = "submitDate")
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="productOrderId")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Basic
    @Column(name = "complaintStatus")
    public ComplaintStatus getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatus complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complaint complaint = (Complaint) o;
        return Objects.equals(order, complaint.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }
}
