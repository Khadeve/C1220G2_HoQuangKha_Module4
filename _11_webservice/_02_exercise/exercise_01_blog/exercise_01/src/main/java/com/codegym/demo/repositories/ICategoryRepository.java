package com.codegym.demo.repositories;

import com.codegym.demo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    @Query(
            value = "select c.id, c.name from categories c " +
                    "inner join blogs_categories bc on c.id = bc.category_id " +
                    "inner join blogs b on b.id = bc.blog_id " +
                    "where b.id = ?1", nativeQuery = true
    )
    List<Category> findAllWithBlogId(Long blogId);
}
