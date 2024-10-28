package com.api.routes.inventory.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryModel {
  private Integer updateProductId;
  private String reason;
  private String updateDate;
  private Integer productId;
  private String productName;
  private Integer categoryId;
  private String categoryName;
  private Integer unitPrice;
  private Integer supplierId;
  private String supplierName;
  private Integer transactionTypeId;
  private String transactionType;
  private Integer updateAmount;
  private boolean isActive;

  public Integer getUpdateProductId() {
    return updateProductId;
  }

  public InventoryModel setUpdateProductId(Integer updateProductId) {
    this.updateProductId = updateProductId;
    return this;
  }

  public InventoryModel setUpdateProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateProductId = rs.getInt("UPDATEPRODUCTID");
    return this;
  }

  public String getReason() {
    return reason;
  }

  public InventoryModel setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public InventoryModel setReason(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.reason = rs.getString("REASON");
    return this;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public InventoryModel setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public InventoryModel setUpdateDate(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateDate = rs.getString("UPDATEDATE");
    return this;
  }

  public Integer getProductId() {
    return productId;
  }

  public InventoryModel setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public InventoryModel setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productId = rs.getInt("PRODUCTID");
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public InventoryModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public InventoryModel setProductName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productName = rs.getString("PRODUCTNAME");
    return this;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public InventoryModel setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  public InventoryModel setCategoryId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.categoryId = rs.getInt("CATEGORYID");
    return this;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public InventoryModel setCategoryName(String categoryName) {
    this.categoryName = categoryName;
    return this;
  }

  public InventoryModel setCategoryName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.categoryName = rs.getString("CATEGORYNAME");
    return this;
  }

  public Integer getUnitPrice() {
    return unitPrice;
  }

  public InventoryModel setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

  public InventoryModel setUnitPrice(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.unitPrice = rs.getInt("UNITPRICE");
    return this;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public InventoryModel setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public InventoryModel setSupplierId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierId = rs.getInt("SUPPLIERID");
    return this;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public InventoryModel setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    return this;
  }

  public InventoryModel setSupplierName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierName = rs.getString("SUPPLIERNAME");
    return this;
  }

  public Integer getTransactionTypeId() {
    return transactionTypeId;
  }

  public InventoryModel setTransactionTypeId(Integer transactionTypeId) {
    this.transactionTypeId = transactionTypeId;
    return this;
  }

  public InventoryModel setTransactionTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionTypeId = rs.getInt("TRANSACTIONTYPEID");
    return this;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public InventoryModel setTransactionType(String transactionType) {
    this.transactionType = transactionType;
    return this;
  }

  public InventoryModel setTransactionType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.transactionType = rs.getString("TRANSACTIONTYPE");
    return this;
  }

  public Integer getUpdateAmount() {
    return updateAmount;
  }

  public InventoryModel setUpdateAmount(Integer updateAmount) {
    this.updateAmount = updateAmount;
    return this;
  }

  public InventoryModel setUpdateAmount(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.updateAmount = rs.getInt("UPDATEAMOUNT");
    return this;
  }

  public boolean getActive() {
    return isActive;
  }

  public InventoryModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public InventoryModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of InventoryModel.
   *
   * @return the current instance of InventoryModel
   */
  public InventoryModel build() {
    return this;
  }
}
