package com.chriscorp.epay.repository;

import com.chriscorp.epay.model.PaymentData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDataJpaRepository extends JpaRepository<PaymentData, Long> {
}
