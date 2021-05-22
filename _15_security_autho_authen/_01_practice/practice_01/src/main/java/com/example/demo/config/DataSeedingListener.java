package com.example.demo.config;

import com.example.demo.Repositories.IRoleRepository;
import com.example.demo.Repositories.IUserRepository;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.utils.EncryptPasswordUtil;
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
        if (userRepository.findByEmail("user@gmail.com") == null) {
            User user = new User();
            user.setEmail("user@gmail.com");
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
        if (userRepository.findByEmail("admin@gmail.com") == null) {
            User user = new User();
            user.setEmail("admin@gmail.com");
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
        if (userRepository.findByEmail("dba@gmail.com") == null) {
            User user = new User();
            user.setEmail("dba@gmail.com");
            user.setPassword(EncryptPasswordUtil.encryptPassword("12345"));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findByName("ROLE_DBA"));
            user.setRoles(roles);
            userRepository.save(user);
        }
    }
}
