package com.api.routes.shared.models.inventory;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.api.routes.shared.models.product.ProductModel;

public class ProductMovementModel {
  private Integer updateProductId;
  private String reason;
  private Date updateDate;
  private ProductModel productModel;
  private TransactionTypeModel transactionTypeModel;
  private Integer updateAmount;
  private Date expirationDate;
  private boolean active;

  public Integer getUpdateProductId() {
    return updateProductId;
  }

  public String getReason() {
    return reason;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public ProductModel getProductModel() {
    return productModel;
  }

  public TransactionTypeModel getTransactionTypeModel() {
    return transactionTypeModel;
  }

  public Integer getUpdateAmount() {
    return updateAmount;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public boolean getActive() {
    return active;
  }

  public ProductMovementModel setUpdateProductId(Integer updateProductId) {
    this.updateProductId = updateProductId;
    return this;
  }

  public ProductMovementModel setUpdateProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.updateProductId = rs.getInt("UPDATEPRODUCTID");
    }
    return this;
  }

  public ProductMovementModel setReason(String reason) {
    this.reason = reason;
    return this;
  }

  public ProductMovementModel setReason(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.reason = rs.getString("REASON");
    }
    return this;
  }

  public ProductMovementModel setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
    return this;
  }

  public ProductMovementModel setUpdateDate(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.updateDate = rs.getDate("UPDATEDATE");
    }
    return this;
  }

  public ProductMovementModel setUpdateAmount(Integer updateAmount) {
    this.updateAmount = updateAmount;
    return this;
  }

  public ProductMovementModel setUpdateAmount(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.updateAmount = rs.getInt("UPDATEAMOUNT");
    }
    return this;
  }

  public ProductMovementModel setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
    return this;
  }

  public ProductMovementModel setExpirationDate(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.expirationDate = rs.getDate("EXPIRATIONDATE");
    }
    return this;
  }

  public ProductMovementModel setActive(boolean active) {
    this.active = active;
    return this;
  }

  public ProductMovementModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.active = rs.getBoolean("ACTIVE");
    }
    return this;
  }

  public ProductMovementModel build() {
    return this;
  }
}
