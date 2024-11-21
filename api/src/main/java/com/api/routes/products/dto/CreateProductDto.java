package com.api.routes.products.dto;

public class CreateProductDto {
  private String productName;
  private Integer productCategoryId;
  private Integer productPrice;
  private Integer supplierId;

  public String getProductName() {
    return productName;
  }

  public CreateProductDto setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public Integer getProductCategoryId() {
    return productCategoryId;
  }

  public CreateProductDto setProductCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
    return this;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public CreateProductDto setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public CreateProductDto setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public CreateProductDto build() {
    return this;
  }
}
