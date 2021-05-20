package com.codegym.demo.services;

import com.codegym.demo.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleService {
    Role findByName(String name);
    List<Role> findAll();
    Role findById(Long id);
}
