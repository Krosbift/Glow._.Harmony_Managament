package com.api.routes.products.dto;

public class GetProductDto {
  private String productName;
  private Integer productCategoryId;
  private String productCategory;
  private Integer productPrice;
  private Integer supplierId;
  private String supplierName;

  public String getProductName() {
    return productName;
  }

  public GetProductDto setProductName(String productName) {
    this.productName = productName;
    return this;
  }

  public GetProductDto setProductName(String productName, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.productName = productName;
    return this;
  }

  public Integer getProductCategoryId() {
    return productCategoryId;
  }

  public GetProductDto setProductCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
    return this;
  }

  public GetProductDto setProductCategoryId(Integer productCategoryId, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.productCategoryId = productCategoryId;
    return this;
  }

  public String getProductCategory() {
    return productCategory;
  }

  public GetProductDto setProductCategory(String productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  public GetProductDto setProductCategory(String productCategory, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.productCategory = productCategory;
    return this;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public GetProductDto setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public GetProductDto setProductPrice(Integer productPrice, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.productPrice = productPrice;
    return this;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public GetProductDto setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
    return this;
  }

  public GetProductDto setSupplierId(Integer supplierId, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.supplierId = supplierId;
    return this;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public GetProductDto setSupplierName(String supplierName) {
    this.supplierName = supplierName;
    return this;
  }

  public GetProductDto setSupplierName(String supplierName, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.supplierName = supplierName;
    return this;
  }

  /**
   * Builds and returns the current instance of GetProductDto.
   *
   * @return the current instance of GetProductDto
   */
  public GetProductDto build() {
    return this;
  }
}