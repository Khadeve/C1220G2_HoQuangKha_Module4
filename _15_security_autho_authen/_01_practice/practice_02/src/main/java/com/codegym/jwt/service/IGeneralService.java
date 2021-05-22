package com.codegym.jwt.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    T save(T object);

    void remove(Long id);
}
