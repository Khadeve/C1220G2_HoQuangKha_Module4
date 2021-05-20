package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private LocalDateTime madeTime;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Blog(String name, String content, Category category) {
        this.name = name;
        this.content = content;
        this.category = category;
        this.madeTime = LocalDateTime.now();
    }

    public Blog() {
        this.madeTime = LocalDateTime.now();
    }

    public Blog(String name, String content) {
        this.name = name;
        this.content = content;
        this.madeTime = LocalDateTime.now();
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(LocalDateTime madeTime) {
        this.madeTime = madeTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
