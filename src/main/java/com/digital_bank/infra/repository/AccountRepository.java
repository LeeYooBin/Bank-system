package com.digital_bank.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital_bank.domain.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
