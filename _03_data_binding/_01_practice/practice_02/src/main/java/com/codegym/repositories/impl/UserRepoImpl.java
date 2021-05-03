package com.codegym.repositories.impl;

import com.codegym.models.Login;
import com.codegym.models.User;
import com.codegym.repositories.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    private static List<User> userDb;

    static {
        userDb = new ArrayList<>();
        User u1 = new User();
        u1.setAge(10);
        u1.setName("John");
        u1.setAccount("john");
        u1.setEmail("john@codegym.vn");
        u1.setPassword("123456");
        userDb.add(u1);

        User u2 = new User();
        u2.setAge(15);
        u2.setName("Bill");
        u2.setAccount("bill");
        u2.setEmail("bill@codegym.vn");
        u2.setPassword("1234567");
        userDb.add(u2);

        User u3 = new User();
        u3.setAge(16);
        u3.setName("Mike");
        u3.setAccount("mike");
        u3.setEmail("mike@codegym.vn");
        u3.setPassword("1234568");
        userDb.add(u3);
    }

    @Override
    public User getUser(Login login) {
        for (User user : userDb) {
            if (user.getAccount().equals(login.getAccount()) &&
                    user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
