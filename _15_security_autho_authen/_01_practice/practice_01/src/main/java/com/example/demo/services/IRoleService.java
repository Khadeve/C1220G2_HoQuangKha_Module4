package com.example.demo.services;


import com.example.demo.models.Role;

import java.util.List;

public interface IRoleService {
    Role findByName(String name);

    List<Role> findAll();

    Role findById(Long id);
}
