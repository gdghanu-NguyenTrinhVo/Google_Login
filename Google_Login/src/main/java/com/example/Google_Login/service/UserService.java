package com.example.Google_Login.service;

import com.example.Google_Login.entity.User;
import com.example.Google_Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User handleUserLogin(OAuth2User principal) {
        String email = principal.getAttribute("email");
        String name = principal.getAttribute("name");

        User user = userRepository.findById(email).orElse(null);

        if (user == null) {
            user = new User(email, name);
            userRepository.save(user);
        }
        return user;
    }

}
