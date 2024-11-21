package com.api.routes.shared.models.product;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.api.routes.shared.models.SupplierModel;

public class ProductModel {
  private Integer productId;
  private String productName;
  private ProductCategoryModel productCategoryModel;
  private Integer productPrice;
  private SupplierModel supplierModel;
  private boolean active;

  public Integer getProductId() {
    return productId;
  }

  public String getProductName() {
    return productName;
  }

  public ProductCategoryModel getProductCategoryModel() {
    return productCategoryModel;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public SupplierModel getSupplierModel() {
    return supplierModel;
  }

  public boolean getIsActive() {
    return active;
  }

  public ProductModel setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public ProductModel setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.productId = rs.getInt("PRODUCTID");
    }
    return this;
  }

  public ProductModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public ProductModel setProductName(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.productName = rs.getString("NAME");
    }
    return this;
  }

  public ProductModel setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ProductModel setProductPrice(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.productPrice = rs.getInt("UNITPRICE");
    }
    return this;
  }

  public ProductModel setIsActive(boolean active) {
    this.active = active;
    return this;
  }

  public ProductModel setIsActive(ResultSet rs, boolean setValue) throws SQLException {
    if (setValue) {
      this.active = rs.getBoolean("ACTIVE");
    }
    return this;
  }

  public ProductModel build() {
    return this;
  }
}
