package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.MODEL.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Long> {
}
