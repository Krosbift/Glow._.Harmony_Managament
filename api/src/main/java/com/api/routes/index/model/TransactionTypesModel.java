package com.api.routes.index.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionTypesModel {
  private int transactionTypeId;
  private String transactionType;
  private String description;
  private boolean isActive;

  public int getTransactionTypeId() {
    return transactionTypeId;
  }

  public TransactionTypesModel setTransactionTypeId(int transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public TransactionTypesModel setTransactionTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionTypeId = rs.getInt("TRANSACTIONTYPEID");
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public TransactionTypesModel setTransactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  public TransactionTypesModel setTransactionType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionType = rs.getString("TRANSACTIONTYPE");
    return this;
  }

  public String getDescription() {
    return description;
  }

  public TransactionTypesModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public TransactionTypesModel setDescription(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.description = rs.getString("DESCRIPTION");
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public TransactionTypesModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public TransactionTypesModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
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
