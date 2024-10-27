package com.api.routes.suppliers.builder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.api.routes.suppliers.model.SupplierModel;
import com.api.routes.suppliers.sql.SupplierSql;
import com.api.routes.utils.interfaces.Binds;

public class SupplierBuilder {
  @Autowired
  protected JdbcTemplate jdbcTemplate;

  /**
   * RowMapper implementation to map a ResultSet to a SupplierModel object.
   * This mapper extracts the following fields from the ResultSet:
   * 
   * Each field is set in the SupplierModel object only if the corresponding column exists in the ResultSet.
   * 
   * @throws SQLException if a database access error occurs or this method is called on a closed result set
   */
  protected RowMapper<SupplierModel> supplierRowMapper = new RowMapper<SupplierModel>() {
    @Override
    public SupplierModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      SupplierModel supplier = new SupplierModel()
          .setSupplierId(rs.getInt("SUPPLIERID"), hasColumn(rs, "SUPPLIERID"))
          .setName(rs.getString("SUPPLIERNAME"), hasColumn(rs, "SUPPLIERNAME"))
          .setAddress(rs.getString("SUPPLIERADDRESS"), hasColumn(rs, "SUPPLIERADDRESS"))
          .setPhone(rs.getString("SUPPLIERPHONE"), hasColumn(rs, "SUPPLIERPHONE"))
          .setActive(rs.getBoolean("SUPPLIERACTIVE"), hasColumn(rs, "SUPPLIERACTIVE"))
          .build();

      return supplier;
    }
  };

  /**
   * Finds a supplier by their unique ID.
   *
   * @param supplierId the unique identifier of the supplier to be found
   * @return the SupplierModel object representing the supplier with the specified ID
   */
  protected SupplierModel findSupplierById(int supplierId) {
    return jdbcTemplate.query(SupplierSql.FIND_SUPPLIER_BY_ID.getQuery(), supplierRowMapper, supplierId).get(0);
  }

  /**
   * Constructs a SQL query to find a supplier based on the provided SupplierModel attributes.
   * The query is dynamically built by appending conditions for non-null attributes of the supplier.
   *
   * @param supplier The SupplierModel object containing the attributes to filter the supplier search.
   *                 The attributes that can be used for filtering are:
   *                 - Name
   *                 - Address
   *                 - Phone
   * @return A Binds object containing the constructed SQL query and the corresponding parameters.
   */
  protected Binds buildFindSupplier(SupplierModel supplier) {
    StringBuilder sql = new StringBuilder(SupplierSql.FIND_SUPPLIER.getQuery());
    List<Object> params = new ArrayList<Object>();

    if (supplier.getName() != null) {
      sql.append(" AND NAME = ?");
      params.add(supplier.getName());
    }

    if (supplier.getAddress() != null) {
      sql.append(" AND ADDRESS = ?");
      params.add(supplier.getAddress());
    }

    if (supplier.getPhone() != null) {
      sql.append(" AND PHONENUMBER = ?");
      params.add(supplier.getPhone());
    }

    return new Binds(sql.toString(), params.toArray());
  }

  protected Binds buildCreateSupplier(SupplierModel supplier) {
    StringBuilder sql = new StringBuilder("INSERT INTO TB_IMS_SUPPLIERS ");
    StringBuilder columns = new StringBuilder("(");
    StringBuilder values = new StringBuilder("VALUES (");
    List<Object> params = new ArrayList<>();

    if (supplier.getName() != null) {
      columns.append("NAME, ");
      values.append("?, ");
      params.add(supplier.getName());
    }

    if (supplier.getAddress() != null) {
      columns.append("ADDRESS, ");
      sql.append("?, ");
      params.add(supplier.getAddress());
    }

    if (supplier.getPhone() != null) {
      columns.append("PHONENUMBER, ");
      sql.append("?, ");
      params.add(supplier.getPhone());
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

  protected Binds buildUpdateSupplier(SupplierModel supplier, int supplierId) {
    StringBuilder sql = new StringBuilder("UPDATE TB_IMS_SUPPLIERS SET ");
    List<Object> params = new ArrayList<>();

    if (supplier.getName() != null) {
      sql.append("NAME = ?, ");
      params.add(supplier.getName());
    }

    if (supplier.getAddress() != null) {
      sql.append("ADDRESS = ?, ");
      params.add(supplier.getAddress());
    }

    if (supplier.getPhone() != null) {
      sql.append("PHONENUMBER = ?, ");
      params.add(supplier.getPhone());
    }

    if (sql.charAt(sql.length() - 2) == ',') {
      sql.setLength(sql.length() - 2);
    }

    sql.append(" WHERE SUPPLIERID = ?");
    params.add(supplierId);

    return new Binds(sql.toString(), params.toArray());
  }

  /**
   * Checks if the ResultSet contains the specified column.
   * 
   * @param rs the ResultSet to check
   * @param column the name of the column to check for
   * @return true if the ResultSet contains the specified column, false otherwise
   * @throws SQLException if a database access error occurs or this method is called on a closed result set
   */
  protected boolean hasColumn(ResultSet rs, String column) throws SQLException {
    ResultSetMetaData rsmd = rs.getMetaData();
    int columns = rsmd.getColumnCount();
    for (int x = 1; x <= columns; x++) {
      if (column.equals(rsmd.getColumnName(x))) {
        return true;
      }
    }
    return false;
  }
}
