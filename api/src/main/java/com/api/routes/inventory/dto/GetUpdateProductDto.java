package com.api.routes.inventory.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetUpdateProductDto {
  private Integer productId;
  private String productName;
  private Integer transactionTypeId;
  private String transactionType;

  public Integer getProductId() {
    return productId;
  }

  public GetUpdateProductDto setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public GetUpdateProductDto setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productId = rs.getInt("PRODUCTID");
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public GetUpdateProductDto setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public GetUpdateProductDto setProductName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productName = rs.getString("PRODUCTNAME");
    return this;
  }

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public GetUpdateProductDto setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public GetUpdateProductDto setTransactionTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionTypeId = rs.getInt("TRANSACTIONTYPEID");
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public GetUpdateProductDto setTransactionType(String transactionTypeId) {
    this.transactionType = transactionTypeId;
    return this;
  }

  public GetUpdateProductDto setTransactionType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionType = rs.getString("TRANSACTIONTYPE");
    return this;
  }

  /**
   * Builds and returns the current instance of GetUpdateProductDto.
   *
   * @return the current instance of GetUpdateProductDto
   */
  public GetUpdateProductDto build() {
    return this;
  }
}
