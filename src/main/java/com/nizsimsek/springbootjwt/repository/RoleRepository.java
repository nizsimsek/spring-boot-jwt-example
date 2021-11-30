package com.nizsimsek.springbootjwt.repository;

import com.nizsimsek.springbootjwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByName(String name);
}
