package com.digital_bank.entrypoint.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital_bank.domain.model.Account;
import com.digital_bank.infra.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
  private final AccountService accountService;

  public AccountController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping
  public ResponseEntity<List<Account>> getAllAccounts() {
    List<Account> accounts = accountService.getAllAccounts();
    return ResponseEntity.ok(accounts);
  }

  @GetMapping("/{accountId}/balance")
  public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable Long accountId) {
    BigDecimal balance = accountService.getAccountBalance(accountId);
    return ResponseEntity.ok(balance);
  }

  @PostMapping
  public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    Account newAccount = accountService.createAccount(account);
    return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
  }
}
