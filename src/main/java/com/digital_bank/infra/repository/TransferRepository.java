package com.digital_bank.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_bank.domain.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
