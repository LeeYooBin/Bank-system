package com.digital_bank.entrypoint.dto;

import java.math.BigDecimal;

public class TransferDTO {
  private Long id;
  private Long accountOriginId;
  private Long accountDestinationId;
  private BigDecimal amount;
  
  public TransferDTO() {
  }

  public TransferDTO(Long id, Long accountOriginId, Long accountDestinationId, BigDecimal amount) {
    this.id = id;
    this.accountOriginId = accountOriginId;
    this.accountDestinationId = accountDestinationId;
    this.amount = amount;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getAccountOriginId() {
    return accountOriginId;
  }

  public void setAccountOriginId(Long accountOriginId) {
    this.accountOriginId = accountOriginId;
  }

  public Long getAccountDestinationId() {
    return accountDestinationId;
  }

  public void setAccountDestinationId(Long accountDestinationId) {
    this.accountDestinationId = accountDestinationId;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }
}
