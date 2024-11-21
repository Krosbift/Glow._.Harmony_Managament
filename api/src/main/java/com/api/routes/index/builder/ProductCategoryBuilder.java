package com.api.routes.index.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.shared.utils.methods.HasColumns;
import com.api.routes.shared.models.product.ProductCategoryModel;

public class ProductCategoryBuilder {
  /**
   * RowMapper implementation for mapping rows of a ResultSet to ProductCategoryModel
   * objects.
   * This mapper is used to convert the ResultSet rows into ProductCategoryModel instances.
   */
  public static RowMapper<ProductCategoryModel> productCategoriesRowMapper = new RowMapper<ProductCategoryModel>() {
    @Override
    public ProductCategoryModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      ProductCategoryModel productCategory = new ProductCategoryModel()
          .setProductCategoryId(rs, HasColumns.verify(rs, "PRODUCTCATEGORYID"))
          .setProductCategory(rs, HasColumns.verify(rs, "NAME"))
          .setDescription(rs, HasColumns.verify(rs, "DESCRIPTION"))
          .setActive(rs, HasColumns.verify(rs, "ACTIVE"))
          .build();
      return productCategory;
    }
  };
}
