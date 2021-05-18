package com.example.demo.service;

import com.example.demo.model.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();
    Smartphone findById(Long id);
    Smartphone save(Smartphone smartphone);
    void delete(Smartphone smartphone);
}
