package com.api.routes.index.model;

import java.sql.ResultSet;
import java.sql.SQLException;

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

  public ProductCategoriesModel setProductCategoryId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.productCategoryId = rs.getInt("PRODUCTCATEGORYID");
    return this;
  }

  public String getName() {
    return name;
  }

  public ProductCategoriesModel setName(String name) {
    this.name = name;
    return this;
  }

  public ProductCategoriesModel setName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.name = rs.getString("NAME");
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ProductCategoriesModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public ProductCategoriesModel setDescription(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.description = rs.getString("DESCRIPTION");
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public ProductCategoriesModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public ProductCategoriesModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
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
