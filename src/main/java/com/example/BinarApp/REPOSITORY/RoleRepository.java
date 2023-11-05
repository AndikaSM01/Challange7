package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.ENTITY.Roles;
import com.example.BinarApp.MODEL.ENUM.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Roles, Integer> {
    Optional<Roles> findByRoleName(ERole name);
}
