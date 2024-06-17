package com.digital_bank.entrypoint.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital_bank.domain.model.Transfer;
import com.digital_bank.infra.service.TransferService;

@RestController
@RequestMapping("/transfers")
public class TransferController {
  private final TransferService transferService;

  public TransferController(TransferService transferService) {
    this.transferService = transferService;
  }

  @GetMapping
  public ResponseEntity<List<Transfer>> getAllTransfers() {
    List<Transfer> transfers = transferService.getAllTransfers();
    return ResponseEntity.ok(transfers);
  }

  @PostMapping
  public ResponseEntity<Transfer> transferFunds(
    @RequestParam Long originAccountId,
    @RequestParam Long destinationAccountId,
    @RequestParam BigDecimal amount
  ) {
    Transfer transfer = transferService.transferFunds(originAccountId, destinationAccountId, amount);
    return ResponseEntity.status(HttpStatus.CREATED).body(transfer);
  }
}
