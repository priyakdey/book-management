package com.example.goodreads.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "review-id-gen")
    @SequenceGenerator(name = "review-id-gen", sequenceName = "seq_review_id",
                    initialValue = 1000, allocationSize = 1)
    private Integer id;

    @Lob
    private String review;

    @ManyToOne
    private User postedBy;

    public Review() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }
}
