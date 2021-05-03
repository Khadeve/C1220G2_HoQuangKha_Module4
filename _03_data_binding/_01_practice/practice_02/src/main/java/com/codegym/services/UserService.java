package com.codegym.services;

import com.codegym.models.Login;
import com.codegym.models.User;

public interface UserService {
    User getUser(Login login);
}
