package com.pizzashop.models;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by barte on 09/12/2016.
 */
@Entity
public class Complaint {
    private Integer complaintId;
    private Date submitDate;
    private String comment;
    private ProductOrder productOrder;

    @Enumerated(EnumType.STRING)
    private ComplaintStatus complaintStatus;

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


    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="productOrderId")
    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
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

        if (complaintId != null ? !complaintId.equals(complaint.complaintId) : complaint.complaintId != null)
            return false;
        if (submitDate != null ? !submitDate.equals(complaint.submitDate) : complaint.submitDate != null) return false;
        if (comment != null ? !comment.equals(complaint.comment) : complaint.comment != null) return false;
        if (productOrder != null ? !productOrder.equals(complaint.productOrder) : complaint.productOrder != null)
            return false;
        return complaintStatus == complaint.complaintStatus;

    }

    @Override
    public int hashCode() {
        int result = complaintId != null ? complaintId.hashCode() : 0;
        result = 31 * result + (submitDate != null ? submitDate.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (productOrder != null ? productOrder.hashCode() : 0);
        result = 31 * result + (complaintStatus != null ? complaintStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId=" + complaintId +
                ", submitDate=" + submitDate +
                ", comment='" + comment + '\'' +
                ", productOrder=" + productOrder +
                ", complaintStatus=" + complaintStatus +
                '}';
    }
}
