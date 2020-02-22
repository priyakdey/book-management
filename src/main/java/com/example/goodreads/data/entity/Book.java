package com.example.goodreads.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book",
        indexes = {
            @Index(name = "index_book_title", columnList = "title")
        })
@NamedQueries(
        @NamedQuery(name = "query.Book.findBookByTitle",
                    query = "select b from Book b join fetch b.authors a where b.title = :title")
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book-id-gen")
    @SequenceGenerator(name = "book-id-gen", sequenceName = "seq_book_id",
                        initialValue = 1000, allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(name = "avg_rating")
    private Double avgRating;


    @ManyToMany(fetch = FetchType.EAGER,
                cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "author_book_join",
                joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private List<Author> authors = new ArrayList<>();


    @OneToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
                orphanRemoval = true)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private List<Review> reviews;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addBookToAuthors() {
        authors.forEach(author -> {
            author.getAuthoredBooks().add(this);
        });
    }
}
