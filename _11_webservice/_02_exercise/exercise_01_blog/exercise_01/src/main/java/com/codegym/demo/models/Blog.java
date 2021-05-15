package com.codegym.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;
    private LocalDateTime madeTime;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonBackReference
    @JoinTable(
            name = "blogs_categories",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    public Blog(String name, String content, Set<Category> categories) {
        this.name = name;
        this.content = content;
        this.categories = categories;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public LocalDateTime getMadeTime() {
        return madeTime;
    }

    public void setMadeTime(LocalDateTime madeTime) {
        this.madeTime = madeTime;
    }
}
