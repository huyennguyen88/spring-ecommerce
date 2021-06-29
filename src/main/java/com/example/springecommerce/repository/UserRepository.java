package com.example.springecommerce.repository;

import com.example.springecommerce.entity.User;
import com.example.springecommerce.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}
