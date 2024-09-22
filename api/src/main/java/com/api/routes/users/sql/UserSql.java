package com.api.routes.users.sql;
/**
 * Enum representing SQL queries for user-related database operations.
 * Each enum constant holds a specific SQL query string.
 * <p>
 * Available queries:
 * <ul>
 *   <li>{@link #FIND_USER_BY_ID} - Retrieves user details by user ID.</li>
 *   <li>{@link #FIND_USER_BY_EMAIL} - Retrieves user details by user email.</li>
 *   <li>{@link #FIND_ALL_USERS} - Retrieves all users from the database.</li>
 *   <li>{@link #FIND_LOGIN_USER} - Retrieves user by user email.</li>
 *   <li>{@link #ACTIVE_USER} - Activates a user by setting the ACTIVE field to 1.</li>
 *   <li>{@link #DELETE_USER} - Deactivates a user by setting the ACTIVE field to 0.</li>
 * </ul>
 * Example usage:
 * <pre>
 * {@code
 * String query = UserSql.FIND_USER_BY_ID.getQuery();
 * }
 * </pre>
 */
public enum UserSql {
  FIND_USER_BY_ID(
    "SELECT " +
      "TIU.USERID, " +
      "TIU.NAMES, " + 
      "TIU.SURNAMES, " +
      "TIU.DOCUMENTTYPEID, " +
      "TID.DOCUMENTTYPE, " +
      "TIU.DOCUMENTNUMBER, " +
      "TIU.EMAIL, " + 
      "TIU.PASSWORD, " +
      "TIU.PHONENUMBER, " +
      "TIU.ROLETYPEID, " +
      "TIR.ROLETYPE, " +
      "TIU.ADDRESS " + 
    "FROM TB_IMC_USERS TIU " +
    "JOIN TB_IMC_ROLETYPES TIR ON TIU.ROLETYPEID = TIR.ROLETYPEID " +
    "JOIN TB_IMC_DOCUMENTTYPES TID ON TIU.DOCUMENTTYPEID = TID.DOCUMENTTYPEID " +
    "WHERE TIU.USERID = ?"
  ),
  FIND_USER_BY_EMAIL(
    "SELECT " +
      "TIU.USERID, " +
      "TIU.NAMES, " + 
      "TIU.SURNAMES, " +
      "TIU.DOCUMENTTYPEID, " +
      "TID.DOCUMENTTYPE, " +
      "TIU.DOCUMENTNUMBER, " +
      "TIU.EMAIL, " + 
      "TIU.PHONENUMBER, " +
      "TIU.ROLETYPEID, " +
      "TIR.ROLETYPE, " +
      "TIU.ADDRESS " +
    "FROM TB_IMC_USERS TIU " +
    "JOIN TB_IMC_ROLETYPES TIR ON TIU.ROLETYPEID = TIR.ROLETYPEID " +
    "JOIN TB_IMC_DOCUMENTTYPES TID ON TIU.DOCUMENTTYPEID = TID.DOCUMENTTYPEID " +
    "WHERE TIU.ACTIVE = 1"
  ),
  FIND_ALL_USERS(
    "SELECT " +
      "TIU.USERID, " +
      "TIU.NAMES, " + 
      "TIU.SURNAMES, " +
      "TIU.DOCUMENTTYPEID, " +
      "TID.DOCUMENTTYPE, " +
      "TIU.DOCUMENTNUMBER, " +
      "TIU.EMAIL, " + 
      "TIU.PHONENUMBER, " +
      "TIU.ROLETYPEID, " +
      "TIR.ROLETYPE, " +
      "TIU.ADDRESS, " +
      "TIU.ACTIVE " +
    "FROM TB_IMC_USERS TIU " +
    "JOIN TB_IMC_ROLETYPES TIR ON TIU.ROLETYPEID = TIR.ROLETYPEID " +
    "JOIN TB_IMC_DOCUMENTTYPES TID ON TIU.DOCUMENTTYPEID = TID.DOCUMENTTYPEID"
  ),
  FIND_LOGIN_USER(
    "SELECT " +
      "TIU.EMAIL, " + 
      "TIU.PASSWORD " +
    "FROM TB_IMC_USERS TIU " +
    "WHERE TIU.ACTIVE = 1"
  ),
  ACTIVE_USER(
    "UPDATE TB_IMC_USERS " +
    "SET ACTIVE = 1 " +
    "WHERE USERID = ?"
  ),
  DELETE_USER(
    "UPDATE TB_IMC_USERS " +
    "SET ACTIVE = 0 " +
    "WHERE USERID = ?"
  );
  /**
   * The SQL query string used for user-related database operations.
   */
  private final String query;
  /**
   * Constructs a new UserSql instance with the specified SQL query.
   *
   * @param query the SQL query to be used by this UserSql instance
   */
  UserSql(String query) {
    this.query = query;
  }
  /**
   * Retrieves the SQL query string.
   *
   * @return the SQL query string.
   */
  public String getQuery() {
    return query;
  }
}
