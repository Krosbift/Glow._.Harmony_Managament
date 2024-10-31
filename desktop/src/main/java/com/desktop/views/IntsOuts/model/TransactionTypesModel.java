package com.desktop.views.IntsOuts.model;

public class TransactionTypesModel {
  private Integer transactionTypeId;
  private String transactionType;
  private String description;
  private boolean isActive;

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public TransactionTypesModel setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public TransactionTypesModel setTransactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public TransactionTypesModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public TransactionTypesModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Builds and returns the current instance of TransactionTypesModel.
   *
   * @return the current instance of TransactionTypesModel
   */
  public TransactionTypesModel build() {
    return this;
  }
}
