package com.api.routes.inventory.model;

public class ProductStockModel {
  private Integer productId;
  private String productName;
  private Integer productCategoryId;
  private String productCategory;
  private Integer productPrice;
  private Integer supplierId;
  private String supplierName;
  private Integer stock;
  private boolean isActive;

  public Integer getProductId() {
    return productId;
  }

  public ProductStockModel setProductId(Integer productId) {
    this.productId = productId;
    return this;
  }

  public String getProductName() {
    return productName;
  }

  public ProductStockModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public Integer getProductCategoryId() {
    return productCategoryId;
  }

  public ProductStockModel setProductCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
    return this;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public ProductStockModel setProductCategory(String productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public ProductStockModel setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public ProductStockModel setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public ProductStockModel setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    return this;
  }

  public Integer getStock() {
    return stock;
  }

  public ProductStockModel setStock(Integer stock) {
    this.stock = stock;
    return this;
  }

  public boolean getActive() {
    return isActive;
  }

  public ProductStockModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Builds and returns the current instance of ProductStockModel.
   *
   * @return the current instance of ProductStockModel
   */
  public ProductStockModel build() {
    return this;
  }
}
