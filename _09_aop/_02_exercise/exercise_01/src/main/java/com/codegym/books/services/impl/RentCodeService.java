package com.codegym.books.services.impl;

import com.codegym.books.models.RentCode;
import com.codegym.books.repositories.IRentCodeRepository;
import com.codegym.books.services.IRentCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentCodeService implements IRentCodeService {
    @Autowired
    IRentCodeRepository rentCodeRepository;

    @Override
    public List<RentCode> findAll() {
        return rentCodeRepository.findAll();
    }

    @Override
    public RentCode findById(Long id) {
        return rentCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentCode rentCode) {
        rentCodeRepository.save(rentCode);
    }

    @Override
    public void delete(RentCode rentCode) {
        rentCodeRepository.delete(rentCode);
    }
}
