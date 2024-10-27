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
      "IUS.USERID, " +
      "IUS.NAMES, " + 
      "IUS.SURNAMES, " +
      "IUS.DOCUMENTTYPEID, " +
      "IDT.DOCUMENTTYPE, " +
      "IUS.DOCUMENTNUMBER, " +
      "IUS.EMAIL, " + 
      "IUS.PASSWORD, " +
      "IUS.PHONENUMBER, " +
      "IUS.ROLETYPEID, " +
      "IRT.ROLETYPE, " +
      "IUS.ADDRESS, " +
      "IUS.ACTIVE " +
    "FROM TB_IMS_USERS IUS " +
    "JOIN TB_IMS_ROLETYPES IRT ON IUS.ROLETYPEID = IRT.ROLETYPEID " +
    "JOIN TB_IMS_DOCUMENTTYPES IDT ON IUS.DOCUMENTTYPEID = IDT.DOCUMENTTYPEID " +
    "WHERE IUS.USERID = ?"
  ),
  FIND_USER(
    "SELECT " +
      "IUS.USERID, " +
      "IUS.NAMES, " + 
      "IUS.SURNAMES, " +
      "IUS.DOCUMENTTYPEID, " +
      "IDT.DOCUMENTTYPE, " +
      "IUS.DOCUMENTNUMBER, " +
      "IUS.EMAIL, " + 
      "IUS.PHONENUMBER, " +
      "IUS.ROLETYPEID, " +
      "IRT.ROLETYPE, " +
      "IUS.ADDRESS, " +
      "IUS.ACTIVE " +
    "FROM TB_IMS_USERS IUS " +
    "JOIN TB_IMS_ROLETYPES IRT ON IUS.ROLETYPEID = IRT.ROLETYPEID " +
    "JOIN TB_IMS_DOCUMENTTYPES IDT ON IUS.DOCUMENTTYPEID = IDT.DOCUMENTTYPEID " +
    "WHERE IUS.ACTIVE = 1"
  ),
  FIND_ALL_USERS(
    "SELECT " +
      "IUS.USERID, " +
      "IUS.NAMES, " + 
      "IUS.SURNAMES, " +
      "IUS.DOCUMENTTYPEID, " +
      "IDT.DOCUMENTTYPE, " +
      "IUS.DOCUMENTNUMBER, " +
      "IUS.EMAIL, " + 
      "IUS.PHONENUMBER, " +
      "IUS.ROLETYPEID, " +
      "IRT.ROLETYPE, " +
      "IUS.ADDRESS, " +
      "IUS.ACTIVE " +
    "FROM TB_IMS_USERS IUS " +
    "JOIN TB_IMS_ROLETYPES IRT ON IUS.ROLETYPEID = IRT.ROLETYPEID " +
    "JOIN TB_IMS_DOCUMENTTYPES IDT ON IUS.DOCUMENTTYPEID = IDT.DOCUMENTTYPEID"
  ),
  FIND_LOGIN_USER(
    "SELECT " +
      "IUS.EMAIL, " + 
      "IUS.PASSWORD " +
    "FROM TB_IMS_USERS IUS " +
    "WHERE IUS.ACTIVE = 1"
  ),
  ACTIVE_USER(
    "UPDATE TB_IMS_USERS " +
    "SET ACTIVE = 1 " +
    "WHERE USERID = ?"
  ),
  DELETE_USER(
    "UPDATE TB_IMS_USERS " +
    "SET ACTIVE = 0 " +
    "WHERE USERID = ?"
  );

  private final String query;

  UserSql(String query) {
    this.query = query;
  }
  
  public String getQuery() {
    return query;
  }
}
