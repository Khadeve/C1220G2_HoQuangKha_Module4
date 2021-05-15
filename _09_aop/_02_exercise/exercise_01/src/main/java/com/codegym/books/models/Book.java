package com.codegym.books.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "number_available")
    private int numberAvailable;

    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private Set<RentCode> rentCodes;

    public Book() {
    }

    public Book(String name, int numberAvailable, String description, Set<RentCode> rentCodes) {
        this.name = name;
        this.numberAvailable = numberAvailable;
        this.description = description;
        this.rentCodes = rentCodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RentCode> getRentCodes() {
        return rentCodes;
    }

    public void setRentCodes(Set<RentCode> rentCodes) {
        this.rentCodes = rentCodes;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
