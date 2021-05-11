package com.codegym.validation.services;

import com.codegym.validation.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(Long id);
    void save(User user);
}
