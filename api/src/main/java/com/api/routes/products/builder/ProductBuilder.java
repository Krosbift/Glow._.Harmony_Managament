package com.api.routes.products.builder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.products.model.ProductModel;
import com.api.routes.products.sql.ProducSql;
import com.api.routes.utils.interfaces.Binds;

public class ProductBuilder {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  /**
   * RowMapper implementation to map a ResultSet to a ProductModel object.
   * This mapper extracts the following fields from the ResultSet:
   * 
   * Each field is set in the ProductModel object only if the corresponding column
   * exists in the ResultSet.
   * 
   * @throws SQLException if a database access error occurs or this method is
   *                      called on a closed result set
   */
  protected RowMapper<ProductModel> productRowMapper = new RowMapper<ProductModel>() {
    @Override
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      ProductModel product = new ProductModel()
          .setProductId(rs, hasColumn(rs, "PRODUCTID"))
          .setProductName(rs, hasColumn(rs, "NAME"))
          .setProductCategoryId(rs, hasColumn(rs, "CATEGORYID"))
          .setProductCategory(rs, hasColumn(rs, "CATEGORYNAME"))
          .setProductPrice(rs, hasColumn(rs, "UNITPRICE"))
          .setSupplierId(rs, hasColumn(rs, "SUPPLIERID"))
          .setSupplierName(rs, hasColumn(rs, "SUPPLIERNAME"))
          .setIsActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return product;
    }
  };

  /**
   * Finds a product by its unique ID.
   *
   * @param productId the unique identifier of the product to be found
   * @return the ProductModel object representing the product with the specified
   *         ID
   */
  protected ProductModel findProductById(int productId) {
    return jdbcTemplate.query(ProducSql.FIND_PRODUCT_BY_ID.getQuery(), productRowMapper, productId).get(0);
  }

  /**
   * Builds a SQL query and binds for finding a product based on the provided
   * ProductModel attributes. The method dynamically appends conditions to the
   * query based on non-null and non-zero attributes of the ProductModel.
   *
   * @param product The ProductModel object containing the search criteria.
   * @return A Binds object containing the constructed SQL query and the
   *         corresponding bind parameters.
   */
  protected Binds buildFindProduct(ProductModel product) {
    List<Object> binds = new ArrayList<>();
    StringBuilder query = new StringBuilder(ProducSql.FIND_PRODUCT.getQuery());

    if (product.getProductName() != null) {
      query.append(" AND IPT.NAME = ?");
      binds.add(product.getProductName());
    }
    if (product.getProductCategoryId() != null) {
      query.append(" AND IPT.CATEGORYID = ?");
      binds.add(product.getProductCategoryId());
    }
    if (product.getProductCategory() != null) {
      query.append(" AND IPC.CATEGORYNAME = ?");
      binds.add(product.getProductCategory());
    }
    if (product.getProductPrice() != null) {
      query.append(" AND IPT.UNITPRICE = ?");
      binds.add(product.getProductPrice());
    }
    if (product.getSupplierId() != null) {
      query.append(" AND IPT.SUPPLIERID = ?");
      binds.add(product.getSupplierId());
    }
    if (product.getSupplierName() != null) {
      query.append(" AND ISL.SUPPLIERNAME = ?");
      binds.add(product.getSupplierName());
    }

    return new Binds(query.toString(), binds.toArray());
  }

  /**
   * Builds an SQL INSERT statement for creating a new product in the
   * TB_IMS_PRODUCTS table.
   * The method dynamically constructs the SQL query based on the non-null and
   * non-zero fields
   * of the provided ProductModel object.
   *
   * @param product The ProductModel object containing the product details to be
   *                inserted.
   *                The following fields are considered:
   *                - productName: The name of the product.
   *                - productCategoryId: The category ID of the product.
   *                - productPrice: The price of the product.
   *                - supplierId: The supplier ID of the product.
   * @return A Binds object containing the constructed SQL query and the
   *         corresponding parameters.
   */
  protected Binds buildCreateProduct(ProductModel product) {
    StringBuilder sql = new StringBuilder("INSERT INTO TB_IMS_PRODUCTS ");
    StringBuilder columns = new StringBuilder("(");
    StringBuilder values = new StringBuilder("VALUES (");
    List<Object> params = new ArrayList<>();

    if (product.getProductName() != null) {
      columns.append("NAME, ");
      values.append("?, ");
      params.add(product.getProductName());
    }
    if (product.getProductCategoryId() != null) {
      columns.append("CATEGORYID, ");
      values.append("?, ");
      params.add(product.getProductCategoryId());
    }
    if (product.getProductPrice() != null) {
      columns.append("UNITPRICE, ");
      values.append("?, ");
      params.add(product.getProductPrice());
    }
    if (product.getSupplierId() != null) {
      columns.append("SUPPLIERID, ");
      values.append("?, ");
      params.add(product.getSupplierId());
    }

    if (columns.charAt(columns.length() - 2) == ',') {
      columns.setLength(columns.length() - 2);
      values.setLength(values.length() - 2);
    }

    columns.append(") ");
    values.append(") ");
    sql.append(columns).append(values);

    return new Binds(sql.toString(), params.toArray());
  }

  /**
   * Builds an SQL update statement for the TB_IMS_PRODUCTS table based on the
   * provided ProductModel.
   * The method dynamically constructs the SQL query and binds the parameters
   * based on the non-null
   * and non-zero fields of the ProductModel.
   *
   * @param product   The ProductModel object containing the product details to be
   *                  updated.
   * @param productId The ID of the product to be updated.
   * @return A Binds object containing the constructed SQL update statement and
   *         the corresponding parameters.
   */
  protected Binds buildUpdateProduc(ProductModel product, int productId) {
    StringBuilder sql = new StringBuilder("UPDATE TB_IMS_PRODUCTS SET ");
    List<Object> params = new ArrayList<>();

    if (product.getProductName() != null) {
      sql.append("NAME = ?, ");
      params.add(product.getProductName());
    }
    if (product.getProductCategoryId() != null) {
      sql.append("CATEGORYID = ?, ");
      params.add(product.getProductCategoryId());
    }
    if (product.getProductPrice() != null) {
      sql.append("UNITPRICE = ?, ");
      params.add(product.getProductPrice());
    }
    if (product.getSupplierId() != null) {
      sql.append("SUPPLIERID = ?, ");
      params.add(product.getSupplierId());
    }

    if (sql.charAt(sql.length() - 2) == ',') {
      sql.setLength(sql.length() - 2);
    }

    sql.append(" WHERE PRODUCTID = ?");
    params.add(productId);

    return new Binds(sql.toString(), params.toArray());
  }

  /**
   * Checks if the specified column exists in the given ResultSet.
   *
   * @param rs         the ResultSet to check for the column
   * @param columnName the name of the column to check for
   * @return true if the column exists, false otherwise
   * @throws SQLException if a database access error occurs
   */
  private boolean hasColumn(ResultSet rs, String columnName) throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();
    int columnCount = metaData.getColumnCount();
    for (int i = 1; i <= columnCount; i++) {
      if (columnName.equals(metaData.getColumnName(i))) {
        return true;
      }
    }
    return false;
  }
}
