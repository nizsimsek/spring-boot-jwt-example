package com.nizsimsek.springbootjwt.repository;

import com.nizsimsek.springbootjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
