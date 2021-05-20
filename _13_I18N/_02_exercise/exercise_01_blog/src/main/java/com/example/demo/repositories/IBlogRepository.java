package com.example.demo.repositories;

import com.example.demo.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByNameContaining(String name);
    Page<Blog> findAll(Pageable pageable);

    @Query(
            value = "select * from blogs limit ?1, ?2",
            nativeQuery = true
    )
    List<Blog> findAll(int offset, int rowCount);
}
