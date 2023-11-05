package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.ENTITY.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    boolean existsByEmail(String inputEmail);

    boolean existsByUsername(String inputUsername);


}
