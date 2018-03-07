package com.chriscorp.epay.repository;

import com.chriscorp.epay.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerJpaRepository extends JpaRepository <Buyer, Long> {
}
