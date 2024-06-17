package com.digital_bank.infra.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digital_bank.domain.model.Account;
import com.digital_bank.domain.model.Transfer;
import com.digital_bank.infra.repository.AccountRepository;
import com.digital_bank.infra.repository.TransferRepository;

@Service
public class TransferService {
  private final TransferRepository transferRepository;
  private final AccountRepository accountRepository;

  public TransferService(TransferRepository transferRepository, AccountRepository accountRepository) {
    this.transferRepository = transferRepository;
    this.accountRepository = accountRepository;
  }

  public List<Transfer> getAllTransfers() {
    return transferRepository.findAll();
  }

  public Transfer transferFunds(Long originAccountId, Long destinationAccountId, BigDecimal amount) {
    Optional<Account> optionalOriginAccount = accountRepository.findById(originAccountId);
    Optional<Account> optionalDestinationAccount = accountRepository.findById(destinationAccountId);

    if (optionalOriginAccount.isPresent() && optionalDestinationAccount.isPresent()) {
      Account originAccount = optionalOriginAccount.get();
      Account destinationAccount = optionalDestinationAccount.get();

      BigDecimal originBalance = originAccount.getBalance();
      if (originBalance.compareTo(amount) >= 0) {
        BigDecimal newOriginBalance = originBalance.subtract(amount);
        BigDecimal newDestinationBalance = destinationAccount.getBalance().add(amount);

        originAccount.setBalance(newOriginBalance);
        destinationAccount.setBalance(newDestinationBalance);

        accountRepository.save(originAccount);
        accountRepository.save(destinationAccount);

        Transfer transfer = new Transfer();
        transfer.setAccountOrigin(originAccount);
        transfer.setAccountDestination(destinationAccount);
        transfer.setAmount(amount);

        return transferRepository.save(transfer);
      } 
      else {
        throw new RuntimeException("Saldo insuficiente na conta de origem");
      }
    } 
    else {
      throw new RuntimeException("Conta de origem ou conta de destino não encontrada");
    }
  }
}

