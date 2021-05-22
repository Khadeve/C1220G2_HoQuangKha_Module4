package com.codegym.jwt.service;

import com.codegym.jwt.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
