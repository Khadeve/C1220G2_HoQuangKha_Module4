package com.codegym.books.services;

import com.codegym.books.models.RentCode;

import java.util.List;

public interface IRentCodeService {

    List<RentCode> findAll();
    RentCode findById(Long id);
    void save(RentCode rentCode);
    void delete(RentCode rentCode);
}
