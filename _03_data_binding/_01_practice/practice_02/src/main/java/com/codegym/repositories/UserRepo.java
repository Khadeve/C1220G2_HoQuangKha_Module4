package com.codegym.repositories;

import com.codegym.models.Login;
import com.codegym.models.User;

public interface UserRepo {
    User getUser(Login login);
}
