package com.api.routes.inventory.dto;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetInventoryDto {
  private String reason;
  private Date updateDate;
  private Integer productId;
  private String productName;
  private Integer categoryId;
  private String categoryName;
  private Integer supplierId;
  private String supplierName;
  private Integer transactionTypeId;
  private String transactionType;

  public String getReason() {
    return reason;
  }

  public GetInventoryDto setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public GetInventoryDto setReason(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.reason = rs.getString("REASON");
    return this;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public GetInventoryDto setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public GetInventoryDto setUpdateDate(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateDate = rs.getDate("UPDATEDATE");
    return this;
  }

  public Integer getProductId() {
    return productId;
  }

  public GetInventoryDto setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public GetInventoryDto setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productId = rs.getInt("PRODUCTID");
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public GetInventoryDto setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public GetInventoryDto setProductName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productName = rs.getString("PRODUCTNAME");
    return this;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public GetInventoryDto setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public GetInventoryDto setCategoryId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.categoryId = rs.getInt("CATEGORYID");
    return this;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public GetInventoryDto setCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  public GetInventoryDto setCategoryName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.categoryName = rs.getString("CATEGORYNAME");
    return this;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public GetInventoryDto setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public GetInventoryDto setSupplierId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierId = rs.getInt("SUPPLIERID");
    return this;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public GetInventoryDto setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    return this;
  }

  public GetInventoryDto setSupplierName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierName = rs.getString("SUPPLIERNAME");
    return this;
  }

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public GetInventoryDto setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public GetInventoryDto setTransactionTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionTypeId = rs.getInt("TRANSACTIONTYPEID");
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public GetInventoryDto setTransactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  public GetInventoryDto setTransactionType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionType = rs.getString("TRANSACTIONTYPE");
    return this;
  }

  /**
   * Builds and returns the current instance of GetInventoryDto.
   *
   * @return the current instance of GetInventoryDto
   */
  public GetInventoryDto build() {
    return this;
  }
}
