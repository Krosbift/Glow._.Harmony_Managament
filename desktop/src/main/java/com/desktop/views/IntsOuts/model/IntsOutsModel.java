package com.desktop.views.IntsOuts.model;

public class IntsOutsModel {
  private Integer updateProductId;
  private String reason;
  private String updateDate;
  private Integer productId;
  private String productName;
  private Integer transactionTypeId;
  private String transactionType;
  private Integer updateAmount;
  private String expirationDate;
  private Integer active;

  public Integer getUpdateProductId() {
    return updateProductId;
  }

  public IntsOutsModel setUpdateProductId(Integer updateProductId) {
    this.updateProductId = updateProductId;
    return this;
  }

  public String getReason() {
    return reason;
  }

  public IntsOutsModel setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public IntsOutsModel setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public Integer getProductId() {
    return productId;
  }

  public IntsOutsModel setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public IntsOutsModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public IntsOutsModel setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public IntsOutsModel setTransactionType(String transactionTypeId) {
    this.transactionType = transactionTypeId;
    return this;
  }

  public Integer getUpdateAmount() {
    return updateAmount;
  }

  public IntsOutsModel setUpdateAmount(Integer updateAmount) {
    this.updateAmount = updateAmount;
    return this;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public IntsOutsModel setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  public Integer getActive() {
    return active;
  }

  public IntsOutsModel setActive(Integer active) {
    this.active = active;
    return this;
  }

  /**
   * Builds and returns the current instance of IntsOutsModel.
   *
   * @return the current instance of IntsOutsModel
   */
  public IntsOutsModel build() {
    return this;
  }
}
