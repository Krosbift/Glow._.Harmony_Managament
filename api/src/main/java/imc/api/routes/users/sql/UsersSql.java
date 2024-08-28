package imc.api.routes.users.sql;

public enum UsersSql {

  // Consulta para encontrar un usuario por su correo electrónico
  FIND_USER(
    "SELECT " +
      "IDUSER, NAMES, SURNAMES, EMAIL, PASSWORD, IDUSERROL, ACTIVE " +
    "FROM TB_IMC_USERS "
  ),

  // Consulta para crear un nuevo usuario
  CREATE_USER(
    "INSERT INTO TB_IMC_USERS (NAMES, SURNAMES, EMAIL, PASSWORD, IDUSERROL, ACTIVE) " +
    "VALUES (?, ?, ?, ?, ?, ?)"
  ),

  // Consulta para actualizar un usuario existente
  UPDATE_USER(
    "UPDATE TB_IMC_USERS " +
    "SET NAMES = ?, SURNAMES = ?, EMAIL = ?, PASSWORD = ?, IDUSERROL = ?, ACTIVE = ? " +
    "WHERE IDUSER = ?"
  ),

  // Consulta para desactivar un usuario (borrado lógico)
  DELETE_USER(
    "UPDATE TB_IMC_USERS " +
    "SET ACTIVE = 0 " +
    "WHERE IDUSER = ?"
  );

  private final String query;

  UsersSql(String query) {
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

}
