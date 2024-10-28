package com.api.routes.inventory.builder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.model.UpdateProductModel;
import com.api.routes.inventory.sql.InventorySql;
import com.api.routes.utils.interfaces.Binds;

public class InventoryBuilder {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  /**
   * RowMapper implementation to map a ResultSet to a InventoryModel object.
   * This mapper extracts the following fields from the ResultSet:
   * 
   * Each field is set in the InventoryModel object only if the corresponding
   * column
   * exists in the ResultSet.
   * 
   * @throws SQLException if a database access error occurs or this method is
   *                      called on a closed result set
   */
  protected RowMapper<InventoryModel> inventoryRowMapper = new RowMapper<InventoryModel>() {
    @Override
    public InventoryModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      InventoryModel inventory = new InventoryModel()
          .setUpdateProductId(rs, hasColumn(rs, "UPDATEPRODUCTID"))
          .setReason(rs, hasColumn(rs, "REASON"))
          .setUpdateDate(rs, hasColumn(rs, "UPDATEDATE"))
          .setProductId(rs, hasColumn(rs, "PRODUCTID"))
          .setProductName(rs, hasColumn(rs, "PRODUCTNAME"))
          .setCategoryId(rs, hasColumn(rs, "CATEGORYID"))
          .setCategoryName(rs, hasColumn(rs, "CATEGORYNAME"))
          .setUnitPrice(rs, hasColumn(rs, "UNITPRICE"))
          .setSupplierId(rs, hasColumn(rs, "SUPPLIERID"))
          .setSupplierName(rs, hasColumn(rs, "SUPPLIERNAME"))
          .setTransactionTypeId(rs, hasColumn(rs, "TRANSACTIONTYPEID"))
          .setTransactionType(rs, hasColumn(rs, "TRANSACTIONTYPE"))
          .setUpdateAmount(rs, hasColumn(rs, "UPDATEAMOUNT"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return inventory;
    }
  };

  /**
   * Builds a SQL query and binds for finding inventory based on the provided inventory model.
   *
   * @param inventory the inventory model containing the search criteria
   * @return a Binds object containing the constructed SQL query and the corresponding bind parameters
   *
   * The method constructs a SQL query by appending conditions based on the non-null fields of the provided
   * inventory model. The following fields are checked and added to the query if they are not null:
   * - Product Name
   * - Category ID
   * - Category Name
   * - Supplier ID
   * - Supplier Name
   * - Transaction Type ID
   * - Transaction Type
   * - Update Amount
   *
   * The resulting query and bind parameters are encapsulated in a Binds object and returned.
   */
  protected Binds buildFindInventory(InventoryModel inventory) {
    List<Object> binds = new ArrayList<>();
    StringBuilder query = new StringBuilder(InventorySql.FIND_INVENTORY.getQuery());

    if (inventory.getProductName() != null) {
      query.append(" AND IPT.PRODUCTNAME = ?");
      binds.add(inventory.getProductName());
    }
    if (inventory.getCategoryId() != null) {
      query.append(" AND IPT.CATEGORYID = ?");
      binds.add(inventory.getCategoryId());
    }
    if (inventory.getCategoryName() != null) {
      query.append(" AND IPT.CATEGORYNAME = ?");
      binds.add(inventory.getCategoryName());
    }
    if (inventory.getSupplierId() != null) {
      query.append(" AND IPT.SUPPLIERID = ?");
      binds.add(inventory.getSupplierId());
    }
    if (inventory.getSupplierName() != null) {
      query.append(" AND ISP.NAME = ?");
      binds.add(inventory.getSupplierName());
    }
    if (inventory.getTransactionTypeId() != null) {
      query.append(" AND IPT.TRANSACTIONTYPEID = ?");
      binds.add(inventory.getTransactionTypeId());
    }
    if (inventory.getTransactionType() != null) {
      query.append(" AND IPT.TRANSACTIONTYPE = ?");
      binds.add(inventory.getTransactionType());
    }

    return new Binds(query.toString(), binds.toArray());
  }

  /**
   * RowMapper implementation for mapping rows of a ResultSet to
   * UpdateProductModel instances.
   * This mapper is used to convert the result set rows into UpdateProductModel
   * objects.
   * 
   * @throws SQLException if an SQL error occurs while mapping the row
   */
  protected RowMapper<UpdateProductModel> updateProductRowMapper = new RowMapper<UpdateProductModel>() {
    @Override
    public UpdateProductModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      UpdateProductModel updateProduct = new UpdateProductModel()
          .setUpdateProductId(rs, hasColumn(rs, "UPDATEPRODUCTID"))
          .setReason(rs, hasColumn(rs, "REASON"))
          .setUpdateDate(rs, hasColumn(rs, "UPDATEDATE"))
          .setProductId(rs, hasColumn(rs, "PRODUCTID"))
          .setProductName(rs, hasColumn(rs, "PRODUCTNAME"))
          .setTransactionTypeId(rs, hasColumn(rs, "TRANSACTIONTYPEID"))
          .setTransactionType(rs, hasColumn(rs, "TRANSACTIONTYPE"))
          .setUpdateAmount(rs, hasColumn(rs, "UPDATEAMOUNT"))
          .setActive(rs, hasColumn(rs, "ACTIVE"))
          .build();

      return updateProduct;
    }
  };

  /**
   * Finds and returns an UpdateProductModel by its ID.
   *
   * @param updateProductId the ID of the update product to find
   * @return the UpdateProductModel corresponding to the given ID
   */
  protected UpdateProductModel findUpdateProductById(int updateProductId) {
    return jdbcTemplate.query(InventorySql.FIND_UPDATEPRODUCT_BY_ID.getQuery(), updateProductRowMapper, updateProductId)
        .get(0);
  }

  /**
   * Builds a query to find and update a product based on the provided
   * updateProduct model.
   * The query is constructed dynamically based on the non-null fields of the
   * updateProduct model.
   *
   * @param updateProduct the model containing the fields to be used for finding
   *                      and updating the product.
   * @return a Binds object containing the constructed query string and the
   *         corresponding bind parameters.
   */
  protected Binds buildFindUpdateProduct(UpdateProductModel updateProduct) {
    List<Object> binds = new ArrayList<>();
    StringBuilder query = new StringBuilder(InventorySql.FIND_UPDATEPRODUCT.getQuery());

    if (updateProduct.getProductName() != null) {
      query.append(" AND IPT.NAME = ?");
      binds.add(updateProduct.getProductName());
    }
    if (updateProduct.getTransactionTypeId() != null) {
      query.append(" AND IIT.TRANSACTIONTYPEID = ?");
      binds.add(updateProduct.getTransactionTypeId());
    }
    if (updateProduct.getTransactionType() != null) {
      query.append(" AND ITT.TRANSACTIONTYPE = ?");
      binds.add(updateProduct.getTransactionType());
    }
    if (updateProduct.getUpdateAmount() != null) {
      query.append(" AND IIT.UPDATEAMOUNT = ?");
      binds.add(updateProduct.getUpdateAmount());
    }

    return new Binds(query.toString(), binds.toArray());
  }

  /**
   * Builds an SQL query for creating or updating a product in the inventory.
   *
   * This method constructs an SQL INSERT statement for the TB_IMS_INVENTORY table
   * based on the non-null fields of the provided UpdateProductModel object. The
   * columns and values are dynamically appended to the query based on the fields
   * that are not null in the updateProduct parameter.
   *
   * @param updateProduct The model containing the product update information.
   *                      The following fields are considered:
   * @return A Binds object containing the constructed SQL query and the
   *         parameters
   *         to be bound to the query.
   */
  protected Binds buildCreateUpdateProduct(UpdateProductModel updateProduct) {
    StringBuilder sql = new StringBuilder("INSERT INTO TB_IMS_UPDATEPRODUCTS ");
    StringBuilder columns = new StringBuilder("(");
    StringBuilder values = new StringBuilder("VALUES (");
    List<Object> params = new ArrayList<>();

    if (updateProduct.getReason() != null) {
      columns.append("REASON, ");
      values.append("?, ");
      params.add(updateProduct.getReason());
    }
    if (updateProduct.getUpdateDate() != null) {
      columns.append("UPDATEDATE, ");
      values.append("?, ");
      params.add(updateProduct.getUpdateDate());
    }
    if (updateProduct.getProductId() != null) {
      columns.append("PRODUCTID, ");
      values.append("?, ");
      params.add(updateProduct.getProductId());
    }
    if (updateProduct.getTransactionTypeId() != null) {
      columns.append("TRANSACTIONTYPEID, ");
      values.append("?, ");
      params.add(updateProduct.getTransactionTypeId());
    }
    if (updateProduct.getUpdateAmount() != null) {
      columns.append("UPDATEAMOUNT, ");
      values.append("?, ");
      params.add(updateProduct.getUpdateAmount());
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
   * Builds an SQL update statement for updating product information in the inventory.
   *
   * @param updateProduct The model containing the updated product information.
   * @param updateProductId The ID of the product to be updated.
   * @return A Binds object containing the SQL update statement and the parameters to be bound.
   */
  protected Binds buildUpdateUpdateProducts(UpdateProductModel updateProduct, int updateProductId) {
    StringBuilder sql = new StringBuilder("UPDATE TB_IMS_UPDATEPRODUCTS SET ");
    List<Object> params = new ArrayList<>();

    if (updateProduct.getReason() != null) {
      sql.append("REASON = ?, ");
      params.add(updateProduct.getReason());
    }
    if (updateProduct.getUpdateDate() != null) {
      sql.append("UPDATEDATE = ?, ");
      params.add(updateProduct.getUpdateDate());
    }
    if (updateProduct.getProductId() != null) {
      sql.append("PRODUCTID = ?, ");
      params.add(updateProduct.getProductId());
    }
    if (updateProduct.getTransactionTypeId() != null) {
      sql.append("TRANSACTIONTYPEID = ?, ");
      params.add(updateProduct.getTransactionTypeId());
    }
    if (updateProduct.getUpdateAmount() != null) {
      sql.append("UPDATEAMOUNT = ?, ");
      params.add(updateProduct.getUpdateAmount());
    }

    if (sql.charAt(sql.length() - 2) == ',') {
      sql.setLength(sql.length() - 2);
    }

    sql.append(" WHERE UPDATEPRODUCTID = ?");
    params.add(updateProductId);

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
