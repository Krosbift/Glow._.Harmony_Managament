package com.api.routes.inventory.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateProductModel {
  private Integer updateProductId;
  private String reason;
  private Date updateDate;
  private Integer productId;
  private String productName;
  private Integer transactionTypeId;
  private String transactionType;
  private Integer updateAmount;
  private Date expirationDate;
  private Integer active;

  public Integer getUpdateProductId() {
    return updateProductId;
  }

  public UpdateProductModel setUpdateProductId(Integer updateProductId) {
    this.updateProductId = updateProductId;
    return this;
  }

  public UpdateProductModel setUpdateProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateProductId = rs.getInt("UPDATEPRODUCTID");
    return this;
  }

  public String getReason() {
    return reason;
  }

  public UpdateProductModel setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public UpdateProductModel setReason(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.reason = rs.getString("REASON");
    return this;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public UpdateProductModel setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public UpdateProductModel setUpdateDate(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateDate = rs.getDate("UPDATEDATE");
    return this;
  }

  public Integer getProductId() {
    return productId;
  }

  public UpdateProductModel setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public UpdateProductModel setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productId = rs.getInt("PRODUCTID");
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public UpdateProductModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public UpdateProductModel setProductName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productName = rs.getString("PRODUCTNAME");
    return this;
  }

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public UpdateProductModel setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public UpdateProductModel setTransactionTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionTypeId = rs.getInt("TRANSACTIONTYPEID");
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public UpdateProductModel setTransactionType(String transactionTypeId) {
    this.transactionType = transactionTypeId;
    return this;
  }

  public UpdateProductModel setTransactionType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionType = rs.getString("TRANSACTIONTYPE");
    return this;
  }

  public Integer getUpdateAmount() {
    return updateAmount;
  }

  public UpdateProductModel setUpdateAmount(Integer updateAmount) {
    this.updateAmount = updateAmount;
    return this;
  }

  public UpdateProductModel setUpdateAmount(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateAmount = rs.getInt("UPDATEAMOUNT");
    return this;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public UpdateProductModel setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  public UpdateProductModel setExpirationDate(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.expirationDate = rs.getDate("EXPIRATIONDATE");
    return this;
  }

  public Integer getActive() {
    return active;
  }

  public UpdateProductModel setActive(Integer active) {
    this.active = active;
    return this;
  }

  public UpdateProductModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.active = rs.getInt("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of UpdateProductModel.
   *
   * @return the current instance of UpdateProductModel
   */
  public UpdateProductModel build() {
    return this;
  }
}
