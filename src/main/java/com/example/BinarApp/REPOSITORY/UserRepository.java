package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.MODEL.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    boolean existsByEmail(String inputEmail);

    boolean existsByUsername(String inputUsername);
}
