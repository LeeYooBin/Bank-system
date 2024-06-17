package com.digital_bank.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transfer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "account_origin_id")
  private Account accountOrigin;

  @ManyToOne
  @JoinColumn(name = "account_destination_id")
  private Account accountDestination;

  private BigDecimal amount;

  @CreationTimestamp
  private LocalDateTime createdAt;

  public Transfer() {
  }

  public Transfer(Long id, Account accountOrigin, Account accountDestination, BigDecimal amount,
    LocalDateTime createdAt) {
    this.id = id;
    this.accountOrigin = accountOrigin;
    this.accountDestination = accountDestination;
    this.amount = amount;
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Account getAccountOrigin() {
    return accountOrigin;
  }

  public void setAccountOrigin(Account accountOrigin) {
    this.accountOrigin = accountOrigin;
  }

  public Account getAccountDestination() {
    return accountDestination;
  }

  public void setAccountDestination(Account accountDestination) {
    this.accountDestination = accountDestination;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
