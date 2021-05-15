package com.codegym.books.repositories;

import com.codegym.books.models.RentCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentCodeRepository extends JpaRepository<RentCode, Long> {
}
