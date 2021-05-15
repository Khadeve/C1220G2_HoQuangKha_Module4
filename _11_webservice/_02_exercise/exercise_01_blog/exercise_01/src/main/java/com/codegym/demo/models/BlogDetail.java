package com.codegym.demo.models;

import java.util.List;

public class BlogDetail {
    private Blog blog;
    private List<Category> categories;

    public BlogDetail(Blog blog, List<Category> categories) {
        this.blog = blog;
        this.categories = categories;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
