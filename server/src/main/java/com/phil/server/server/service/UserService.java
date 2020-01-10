package com.phil.server.server.service;

import com.phil.server.server.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    public String signup(User user);
    public String login(User user);
    public UserDetails loadUserByUsername(String username);
}
