package com.codegym.demo.repositories;

import com.codegym.demo.models.Blog;
import com.codegym.demo.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByNameContaining(String name, Pageable pageable);
    List<Blog> findAllByCategoriesContains(Category category);

    @Query(
            value = "SELECT b.id, b.name, b.content, b.made_time, c.name AS category " +
                    "FROM blogs b " +
                    "INNER JOIN blogs_categories bc ON b.id = bc.blog_id " +
                    "INNER JOIN categories c ON c.id = bc.category_id " +
                    "WHERE b.id = ?1", nativeQuery = true
    )
    Blog findDetailBlog(Long id);
}
