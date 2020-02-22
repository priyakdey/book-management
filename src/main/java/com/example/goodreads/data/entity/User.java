package com.example.goodreads.data.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_details",
        indexes = {
            @Index(name = "index_user_name", columnList = "user_name", unique = true)
        })
@NamedQueries(
        @NamedQuery(name = "query.User.findByUserName", query = "select u from User u where u.userName = :userName")
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user-id-gen")
    @SequenceGenerator(name = "user-id-gen", sequenceName = "seq_user_id",
                        initialValue = 1000, allocationSize = 1)
    private Integer id;

    @NaturalId
    @Column(name = "user_name", nullable = false, length = 10, updatable = false, unique = true)
    private String userName;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "signed_up_on", nullable = false, updatable = false)
    private LocalDateTime signedUpOn;

    @Version
    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdatedOn;

    /**
     * default constructor
     */
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getSignedUpOn() {
        return signedUpOn;
    }

    public void setSignedUpOn(LocalDateTime signedUpOn) {
        this.signedUpOn = signedUpOn;
    }

    public LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }
}

