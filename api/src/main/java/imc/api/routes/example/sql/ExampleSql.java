package imc.api.routes.example.sql;

public enum ExampleSql {
  
  // Consulta para encontrar un ejemplo por su ID
  FIND_EXAMPLE(
    "SELECT " +
      "IDEXAMPLE, NAME, DESCRIPTION, ACTIVE " +
    "FROM TB_IMC_EXAMPLES " +
    "WHERE IDEXAMPLE = ?"
  ),

  // Consulta para crear un nuevo ejemplo
  CREATE_EXAMPLE(
    "INSERT INTO TB_IMC_EXAMPLES (NAME, DESCRIPTION) " +
    "VALUES (?, ?)"
  ),

  // Consulta para actualizar un ejemplo existente
  UPDATE_EXAMPLE(
    "UPDATE TB_IMC_EXAMPLES " +
    "SET NAME = ?, DESCRIPTION = ? " +
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
