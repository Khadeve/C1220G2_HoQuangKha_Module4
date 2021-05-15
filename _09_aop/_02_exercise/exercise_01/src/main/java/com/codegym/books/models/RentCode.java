package com.codegym.books.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "rent_code")
public class RentCode {
    @Id
    @Min(11111)
    @Max(99999)
    private Long code;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public RentCode() {
    }

    public RentCode(Long code, Book book) {
        this.code = code;
        this.book = book;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "RentCode{" +
                "code=" + code +
                ", book=" + book +
                '}';
    }
}
