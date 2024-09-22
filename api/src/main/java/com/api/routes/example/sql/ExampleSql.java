package com.api.routes.example.sql;

public enum ExampleSql {
  
  // Consulta para encontrar un ejemplo por su ID
  FIND_EXAMPLE_BY_ID(
    "SELECT " +
      "IDEXAMPLE, NAME, DESCRIPTION, ACTIVE " +
    "FROM TB_IMC_EXAMPLES " +
    "WHERE IDEXAMPLE = ?"
  ),

  // Consulta para desactivar un ejemplo (borrado lógico)
  DELETE_EXAMPLE(
    "UPDATE TB_IMC_EXAMPLES " +
    "SET ACTIVE = 0 " +
    "WHERE IDEXAMPLE = ?"
  );

  private final String query;

  ExampleSql(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

}
