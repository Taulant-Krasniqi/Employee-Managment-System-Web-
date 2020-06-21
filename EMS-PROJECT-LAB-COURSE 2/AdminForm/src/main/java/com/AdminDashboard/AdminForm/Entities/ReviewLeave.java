package com.AdminDashboard.AdminForm.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "review_leave", schema = "admin_data")
public class ReviewLeave {
    private int reviewId;
    private Date dateOfReview;
    private String status;

    @Id
    @Column(name = "ReviewID", nullable = false)
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "DateOfReview", nullable = false)
    public Date getDateOfReview() {
        return dateOfReview;
    }

    public void setDateOfReview(Date dateOfReview) {
        this.dateOfReview = dateOfReview;
    }

    @Basic
    @Column(name = "Status", nullable = false, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewLeave that = (ReviewLeave) o;
        return reviewId == that.reviewId &&
                Objects.equals(dateOfReview, that.dateOfReview) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, dateOfReview, status);
    }
}
