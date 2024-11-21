package com.api.routes.products.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductModel {
  private Integer productId;
  private String productName;
  
  private Integer productCategoryId;
  private String productCategory;

  private Integer productPrice;

  private Integer supplierId;
  private String supplierName;

  private boolean isActive;

  public Integer getProductId() {
    return productId;
  }

  public ProductModel setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public ProductModel setProductId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productId = rs.getInt("PRODUCTID");
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public ProductModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public ProductModel setProductName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productName = rs.getString("NAME");
    return this;
  }

  public Integer getProductCategoryId() {
    return productCategoryId;
  }

  public ProductModel setProductCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
    return this;
  }

  public ProductModel setProductCategoryId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productCategoryId = rs.getInt("CATEGORYID");
    return this;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public ProductModel setProductCategory(String productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  public ProductModel setProductCategory(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productCategory = rs.getString("CATEGORYNAME");
    return this;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public ProductModel setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ProductModel setProductPrice(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productPrice = rs.getInt("UNITPRICE");
    return this;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public ProductModel setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public ProductModel setSupplierId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierId = rs.getInt("SUPPLIERID");
    return this;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public ProductModel setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    return this;
  }

  public ProductModel setSupplierName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.supplierName = rs.getString("SUPPLIERNAME");
    return this;
  }

  public boolean getIsActive() {
    return isActive;
  }

  public ProductModel setIsActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public ProductModel setIsActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of ProductModel.
   *
   * @return the current instance of ProductModel
   */
  public ProductModel build() {
    return this;
  }
}
