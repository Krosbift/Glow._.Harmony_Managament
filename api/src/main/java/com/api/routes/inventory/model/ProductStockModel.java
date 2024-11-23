package com.api.routes.inventory.model;

public class ProductStockModel {
  private String productName;
  private String productCategory;
  private Integer stock;
  private Integer productPrice;
  private Integer totalPrice;
  private String supplierName;

  public String getProductName() {
    return productName;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public Integer getStock() {
    return stock;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public Integer getTotalPrice() {
    return totalPrice;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public ProductStockModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public ProductStockModel setProductCategory(String productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  public ProductStockModel setStock(Integer stock) {
    this.stock = stock;
    return this;
  }

  public ProductStockModel setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public ProductStockModel setTotalPrice(Integer totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  public ProductStockModel setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    return this;
  }

  public ProductStockModel build() {
    return this;
  }
}
