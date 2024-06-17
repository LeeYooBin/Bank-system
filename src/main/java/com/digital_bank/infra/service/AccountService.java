package com.digital_bank.infra.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digital_bank.domain.model.Account;
import com.digital_bank.infra.repository.AccountRepository;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public List<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  public BigDecimal getAccountBalance(Long accountId) {
    Optional<Account> optionalAccount = accountRepository.findById(accountId);
    return optionalAccount.map(Account::getBalance).orElse(BigDecimal.ZERO);
  }

  public Account createAccount(Account account) {
    return accountRepository.save(account);
  }

  public void updateAccountBalance(Long accountId, BigDecimal amount) {
    Optional<Account> optionalAccount = accountRepository.findById(accountId);
    if (optionalAccount.isPresent()) {
      Account account = optionalAccount.get();
      BigDecimal newBalance = account.getBalance().add(amount);
      account.setBalance(newBalance);
      accountRepository.save(account);
    } else {
      throw new RuntimeException("Conta não encontrada");
    }
  }
}

