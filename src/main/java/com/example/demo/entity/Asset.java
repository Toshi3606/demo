package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "ASSET")
public class Asset {

    @Id
    @Column(name = "ASSET_ID")
    private Long assetId;

    @Column(name = "ASSET_NAME", nullable = false)
    private String assetName;

    @Column(name = "ASSET_TYPE", nullable = false)
    private String assetType;

    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

    @Column(name = "DEPOSIT_DATE")
    private LocalDate depositDate;

    @Column(name = "MATURITY_DATE")
    private LocalDate maturityDate;

    @Column(name = "INTEREST_RATE")
    private BigDecimal interestRate;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "PASSWORD")
    private String password;

    public Asset() {
}

public Long getAssetId() {
    return assetId;
}

public void setAssetId(Long assetId) {
    this.assetId = assetId;
}

public String getAssetName() {
    return assetName;
}

public void setAssetName(String assetName) {
    this.assetName = assetName;
}

public String getAssetType() {
    return assetType;
}

public void setAssetType(String assetType) {
    this.assetType = assetType;
}

public BigDecimal getAmount() {
    return amount;
}

public void setAmount(BigDecimal amount) {
    this.amount = amount;
}

public LocalDate getDepositDate() {
    return depositDate;
}

public void setDepositDate(LocalDate depositDate) {
    this.depositDate = depositDate;
}

public LocalDate getMaturityDate() {
    return maturityDate;
}

public void setMaturityDate(LocalDate maturityDate) {
    this.maturityDate = maturityDate;
}

public BigDecimal getInterestRate() {
    return interestRate;
}

public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

public LocalDateTime getUpdatedAt() {
    return updatedAt;
}

public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
}

public String getLoginId() {
    return loginId;
}

public void setLoginId(String loginId) {
    this.loginId = loginId;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
}