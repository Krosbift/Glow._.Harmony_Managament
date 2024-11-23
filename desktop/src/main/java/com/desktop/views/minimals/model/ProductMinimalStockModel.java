package com.desktop.views.minimals.model;

public class ProductMinimalStockModel {
  private String productName;
  private String productCategory;
  private Integer stock;
  private Integer productPrice;

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

  public ProductMinimalStockModel setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public ProductMinimalStockModel setProductCategory(String productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  public ProductMinimalStockModel setStock(Integer stock) {
    this.stock = stock;
    return this;
  }

  public ProductMinimalStockModel setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }
}
