package com.api.routes.interfaces;

/**
 * Represents a container for SQL query and its parameters.
 */
public class Binds {
  private String sql;
  private Object[] params;

  public Binds(String sql, Object[] params) {
    this.sql = sql;
    this.params = params;
  }

  public String getSql() {
    return sql;
  }

  public Object[] getParams() {
    return params;
  }
}
