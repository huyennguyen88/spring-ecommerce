package com.example.springecommerce.repository;

import com.example.springecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByCode(String code);
}
