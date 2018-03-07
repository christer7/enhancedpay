package com.chriscorp.epay.repository;


import com.chriscorp.epay.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<Client, Long> {
}
