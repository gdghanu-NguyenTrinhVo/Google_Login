package com.example.Google_Login.repository;

import com.example.Google_Login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
