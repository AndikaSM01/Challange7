package com.example.BinarApp.REPOSITORY;

import com.example.BinarApp.ENTITY.Merchant;
import com.example.BinarApp.MODEL.ENUM.MerchantEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,String> {
    Boolean existsByMerchantName(String merchantName);
    @Query("SELECT q FROM Merchant q WHERE q.open = :merchantCode")
    List<Merchant>findByMerchantEnum(@Param("merchantCode") MerchantEnum merchantCode);
    Optional<Merchant> findByMerchantCode(String kode);



}
