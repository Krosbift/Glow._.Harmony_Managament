package com.desktop.views.products.model;

public class ProductCategoriesModel {
  private Integer productCategoryId;
  private String name;
  private String description;
  private boolean isActive;

  public Integer getProductCategoryId() {
    return productCategoryId;
  }

  public ProductCategoriesModel setProductCategoryId(Integer productCategoryId) {
    this.productCategoryId = productCategoryId;
    return this;
  }

  public String getName() {
    return name;
  }

  public ProductCategoriesModel setName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ProductCategoriesModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public ProductCategoriesModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  /**
   * Builds and returns the current instance of ProductCategoriesModel.
   *
   * @return the current instance of ProductCategoriesModel
   */
  public ProductCategoriesModel build() {
    return this;
  }
}
