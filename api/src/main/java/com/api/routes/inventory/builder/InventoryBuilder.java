package com.api.routes.inventory.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.inventory.model.InventoryModel;
import com.api.routes.inventory.sql.InventorySql;
import com.api.routes.shared.utils.methods.HasColumns;
import com.api.routes.shared.utils.query.Binds;

public class InventoryBuilder {


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
    @SuppressWarnings("null")
    @Override
    public InventoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
      InventoryModel inventory = new InventoryModel()
          .setUpdateProductId(rs, HasColumns.verify(rs, "UPDATEPRODUCTID"))
          .setReason(rs, HasColumns.verify(rs, "REASON"))
          .setUpdateDate(rs, HasColumns.verify(rs, "UPDATEDATE"))
          .setProductId(rs, HasColumns.verify(rs, "PRODUCTID"))
          .setProductName(rs, HasColumns.verify(rs, "PRODUCTNAME"))
          .setCategoryId(rs, HasColumns.verify(rs, "CATEGORYID"))
          .setCategoryName(rs, HasColumns.verify(rs, "CATEGORYNAME"))
          .setUnitPrice(rs, HasColumns.verify(rs, "UNITPRICE"))
          .setSupplierId(rs, HasColumns.verify(rs, "SUPPLIERID"))
          .setSupplierName(rs, HasColumns.verify(rs, "SUPPLIERNAME"))
          .setTransactionTypeId(rs, HasColumns.verify(rs, "TRANSACTIONTYPEID"))
          .setTransactionType(rs, HasColumns.verify(rs, "TRANSACTIONTYPE"))
          .setUpdateAmount(rs, HasColumns.verify(rs, "UPDATEAMOUNT"))
          .setActive(rs, HasColumns.verify(rs, "ACTIVE"))
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

    if (inventory.getProductId() != null) {
      query.append(" AND IPT.PRODUCTID = ?");
      binds.add(inventory.getProductId());
    }
    if (inventory.getCategoryId() != null) {
      query.append(" AND IPT.CATEGORYID = ?");
      binds.add(inventory.getCategoryId());
    }
    if (inventory.getSupplierId() != null) {
      query.append(" AND IPT.SUPPLIERID = ?");
      binds.add(inventory.getSupplierId());
    }

    return new Binds(query.toString(), binds.toArray());
  }
}
