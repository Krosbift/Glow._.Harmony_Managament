package com.api.routes.inventory.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUpdateProductDto {
  private String reason;
  private Integer productId;
  private Integer transactionTypeId;
  private Integer updateAmount;

  public String getReason() {
    return reason;
  }

  public CreateUpdateProductDto setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public CreateUpdateProductDto setReason(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.reason = rs.getString("REASON");
    return this;
  }

  public Integer getProductId() {
    return productId;
  }

  public CreateUpdateProductDto setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public CreateUpdateProductDto setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productId = rs.getInt("PRODUCTID");
    return this;
  }

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public CreateUpdateProductDto setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public CreateUpdateProductDto setTransactionTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionTypeId = rs.getInt("TRANSACTIONTYPEID");
    return this;
  }

  public Integer getUpdateAmount() {
    return updateAmount;
  }

  public CreateUpdateProductDto setUpdateAmount(Integer updateAmount) {
    this.updateAmount = updateAmount;
    return this;
  }

  public CreateUpdateProductDto setUpdateAmount(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateAmount = rs.getInt("UPDATEAMOUNT");
    return this;
  }

  /**
   * Builds and returns the current instance of CreateUpdateProductDto.
   *
   * @return the current instance of CreateUpdateProductDto
   */
  public CreateUpdateProductDto build() {
    return this;
  }
}
