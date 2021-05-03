package com.codegym.services.impl;

import com.codegym.models.Login;
import com.codegym.models.User;
import com.codegym.repositories.UserRepo;
import com.codegym.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User getUser(Login login) {
        return userRepo.getUser(login);
    }
}
