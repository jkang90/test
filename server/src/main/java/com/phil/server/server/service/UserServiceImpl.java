package com.phil.server.server.service;

import com.phil.server.server.model.User;
import com.phil.server.server.repository.UserRepository;
import com.phil.server.server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;

    @Override
    public String signup(User user) {
        // TODO exception handling to check if user exists
        // TODO add validation around password, username, etc
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return jwtUtil.generateToken(user);
    }

    @Override
    public String login(User user) {
        User loggedInUser = userRepository.findUserByUsername(user.getUsername());
        if(loggedInUser == null){
            return "";
        } else{
            if(!bCryptPasswordEncoder.matches(user.getPassword(), loggedInUser.getPassword())){
                return "";
            }
            return jwtUtil.generateToken(user);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        if(user==null) return null;
        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getUsername()));
        return authorities;
    }
}
