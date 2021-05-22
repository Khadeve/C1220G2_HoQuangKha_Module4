package com.codegym.jwt.configuration;

import com.codegym.jwt.model.Role;
import com.codegym.jwt.model.User;
import com.codegym.jwt.repository.IRoleRepository;
import com.codegym.jwt.repository.IUserRepository;
import com.codegym.jwt.utils.EncryptPasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        Add user role
        if (roleRepository.findByName("ROLE_USER") == null) {
            roleRepository.save(new Role("ROLE_USER"));
        }

//        Initialize an user account
        if (userRepository.findByUsername("user@gmail.com") == null) {
            User user = new User();
            user.setUsername("user@gmail.com");
            user.setFullName("user");
            user.setPassword(EncryptPasswordUtil.encryptPassword("12345"));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_USER"));
            user.setRoles(roles);
            userRepository.save(user);
        }

        //        Add admin role
        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(new Role("ROLE_ADMIN"));
        }

//        Initialize an admin account
        if (userRepository.findByUsername("admin@gmail.com") == null) {
            User user = new User();
            user.setUsername("admin@gmail.com");
            user.setFullName("admin");
            user.setPassword(EncryptPasswordUtil.encryptPassword("12345"));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_ADMIN"));
            user.setRoles(roles);
            userRepository.save(user);
        }

        //        Add dba role
        if (roleRepository.findByName("ROLE_DBA") == null) {
            roleRepository.save(new Role("ROLE_DBA"));
        }

//        Initialize an dba account
        if (userRepository.findByUsername("dba@gmail.com") == null) {
            User user = new User();
            user.setUsername("dba@gmail.com");
            user.setFullName("dba");
            user.setPassword(EncryptPasswordUtil.encryptPassword("12345"));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_DBA"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}
