package com.api.routes.suppliers.sql;

/**
 * Enum representing SQL queries for supplier-related operations.
 * Each enum constant holds a specific SQL query string.
 */
public enum SupplierSql {
  FIND_SUPPLIER_BY_ID(
    "SELECT " +
      "TIS.SUPPLIERID, " +
      "TIS.NAME, " +
      "TIS.ADDRESS, " +
      "TIS.PHONENUMBERNUMBER, " +
    "FROM TB_IMS_SUPPLIERS TIS " +
    "WHERE TIS.SUPPLIERID = ?"
  ),
  FIND_SUPPLIER(
    "SELECT " +
      "TIS.SUPPLIERID, " +
      "TIS.NAME, " +
      "TIS.ADDRESS, " +
      "TIS.PHONENUMBER, " +
    "FROM TB_IMS_SUPPLIERS TIS " +
    "WHERE TIS.ACTIVE = 1"
  ),
  FIND_ALL_SUPPLIERS(
    "SELECT " +
      "TIS.SUPPLIERID, " +
      "TIS.NAME, " +
      "TIS.ADDRESS, " +
      "TIS.PHONENUMBER, " +
      "TIS.ACTIVE " +
    "FROM TB_IMS_SUPPLIERS TIS"
  ),
  ACTIVE_SUPPLIER(
    "UPDATE TB_IMS_SUPPLIERS " +
    "SET ACTIVE = 1 " +
    "WHERE SUPPLIERID = ?"
  ),
  DELETE_SUPPLIER(
    "UPDATE TB_IMS_SUPPLIERS " +
    "SET ACTIVE = 0 " +
    "WHERE SUPPLIERID = ?"
  );

  private final String query;

  SupplierSql(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }
}
