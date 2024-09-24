package com.api.routes.users.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.api.routes.shared.interfaces.Binds;
import com.api.routes.users.model.UserModel;
import com.api.routes.users.sql.UserSql;

public class UserBuilder {
  @Autowired
  protected JdbcTemplate jdbcTemplate;
  /**
   * RowMapper implementation for mapping rows of a ResultSet to UserModel instances.
   * This mapper checks for the presence of each column before attempting to map it to the UserModel.
   * 
   * @throws SQLException if an SQL error occurs while accessing the ResultSet
   */
  protected RowMapper<UserModel> userRowMapper = new RowMapper<UserModel>() {
    @Override
    public UserModel mapRow(@SuppressWarnings("null") ResultSet rs, int rowNum) throws SQLException {
      UserModel user = new UserModel();
      if (hasColumn(rs, "USERID")) user.setUserId(rs.getInt("USERID"));
      if (hasColumn(rs, "NAMES")) user.setNames(rs.getString("NAMES"));
      if (hasColumn(rs, "SURNAMES")) user.setSurNames(rs.getString("SURNAMES"));
      if (hasColumn(rs, "DOCUMENTTYPEID")) user.setDocumentTypeId(rs.getInt("DOCUMENTTYPEID"));
      if (hasColumn(rs, "DOCUMENTTYPE")) user.setDocumentType(rs.getString("DOCUMENTTYPE"));
      if (hasColumn(rs, "DOCUMENTNUMBER")) user.setDocumentNumber(rs.getString("DOCUMENTNUMBER"));
      if (hasColumn(rs, "EMAIL")) user.setEmail(rs.getString("EMAIL"));
      if (hasColumn(rs, "PASSWORD")) user.setPassword(rs.getString("PASSWORD"));
      if (hasColumn(rs, "PHONENUMBER")) user.setPhone(rs.getString("PHONENUMBER"));
      if (hasColumn(rs, "ROLETYPEID")) user.setRoleTypeId(rs.getInt("ROLETYPEID"));
      if (hasColumn(rs, "ROLETYPE")) user.setRoleType(rs.getString("ROLETYPE"));
      if (hasColumn(rs, "ADDRESS")) user.setAddress(rs.getString("ADDRESS"));
      if (hasColumn(rs, "ACTIVE")) user.setActive(rs.getBoolean("ACTIVE"));
      return user; 
    }
  };
  /**
   * Finds a user by their unique ID.
   *
   * @param userId the unique identifier of the user to be found
   * @return the UserModel object representing the user with the specified ID
   */
  protected UserModel findUserById(int userId) {
    return jdbcTemplate.query(UserSql.FIND_USER_BY_ID.getQuery(), userRowMapper, userId).get(0);
  }
  /**
   * Builds the SQL query and parameters for finding a user by email address.
   *
   * @param user The UserModel object containing the user's email address.
   * @return A Binds object containing the constructed SQL query and the parameters.
   */
  protected Binds buildFindUser(UserModel user) {
    StringBuilder sql = new StringBuilder(UserSql.FIND_USER_BY_EMAIL.getQuery());
    List<Object> params = new ArrayList<>();

    if (user.getEmail() != null) {
      sql.append(" AND TIU.EMAIL = ?");
      params.add(user.getEmail());
    }

    return new Binds(sql.toString(), params.toArray());
  }
  /**
   * Builds the SQL query and parameters for finding a user by login credentials.
   *
   * @param user The UserModel object containing the user's login information.
   * If the email is not null, it will be added as a condition in the query.
   * @return A Binds object containing the constructed SQL query and the parameters.
   */
  protected Binds buildFindLoginUser(UserModel user) {
    StringBuilder sql = new StringBuilder(UserSql.FIND_LOGIN_USER.getQuery());
    List<Object> params = new ArrayList<>();

    if (user.getEmail() != null) {
      sql.append(" AND TIU.EMAIL = ?");
      params.add(user.getEmail());
    }

    return new Binds(sql.toString(), params.toArray());
  }
  /**
   * Builds an SQL query to register a new user in the TB_IMC_USERS table.
   * The query is constructed dynamically based on the non-null fields of the provided UserModel object.
   * 
   * @param user The UserModel object containing user details to be registered.
   * @return A Binds object containing the constructed SQL query and the corresponding parameters.
   */
  protected Binds buildRegisterUser(UserModel user) {
    StringBuilder sql = new StringBuilder("INSERT INTO TB_IMC_USERS ");
    StringBuilder columns = new StringBuilder("(");
    StringBuilder values = new StringBuilder("VALUES (");
    List<Object> params = new ArrayList<>();

    if (user.getNames() != null) {
      columns.append("NAMES, ");
      values.append("?, ");
      params.add(user.getNames());   
    }

    if (user.getSurNames() != null) {
      columns.append("SURNAMES, ");
      values.append("?, ");
      params.add(user.getSurNames());
    }

    if (user.getDocumentTypeId() > 0) {
      columns.append("DOCUMENTTYPEID, ");
      values.append("?, ");
      params.add(user.getDocumentTypeId());
    }

    if (user.getDocumentNumber() != null) {
      columns.append("DOCUMENTNUMBER, ");
      values.append("?, ");
      params.add(user.getDocumentNumber());
    }

    if (user.getEmail() != null) {
      columns.append("EMAIL, ");
      values.append("?, ");
      params.add(user.getEmail());
    }

    if (user.getPassword() != null) {
      columns.append("PASSWORD, ");
      values.append("?, ");
      params.add(user.getPassword());
    }

    if (user.getPhone() != null) {
      columns.append("PHONENUMBER, ");
      values.append("?, ");
      params.add(user.getPhone());
    }

    if (user.getRoleTypeId() > 0) {
      columns.append("ROLETYPEID, ");
      values.append("?, ");
      params.add(user.getRoleTypeId());
    }

    if (user.getAddress() != null) {
      columns.append("ADDRESS, ");
      values.append("?, ");
      params.add(user.getAddress());
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
   * Builds an SQL query to update an existing user in the TB_IMC_USERS table.
   * The query is constructed dynamically based on the non-null fields of the provided UserModel object.
   * 
   * @param user The UserModel object containing the updated user details.
   * @param userId The unique identifier of the user to be updated.
   * @return A Binds object containing the constructed SQL query and the corresponding parameters.
   */
  protected Binds buildUpdateUser(UserModel user, int userId) {
    StringBuilder sql = new StringBuilder("UPDATE TB_IMC_USERS SET ");
    List<Object> params = new ArrayList<>();

    if (user.getNames() != null) {
      sql.append("NAMES = ?, ");
      params.add(user.getNames());
    }

    if (user.getSurNames() != null) {
      sql.append("SURNAMES = ?, ");
      params.add(user.getSurNames());
    }

    if (user.getDocumentTypeId() > 0) {
      sql.append("DOCUMENTTYPEID = ?, ");
      params.add(user.getDocumentTypeId());
    }

    if (user.getDocumentNumber() != null) {
      sql.append("DOCUMENTNUMBER = ?, ");
      params.add(user.getDocumentNumber());
    }

    if (user.getEmail() != null) {
      sql.append("EMAIL = ?, ");
      params.add(user.getEmail());
    }

    if (user.getPassword() != null) {
      sql.append("PASSWORD = ?, ");
      params.add(user.getPassword());
    }

    if (user.getPhone() != null) {
      sql.append("PHONENUMBER = ?, ");
      params.add(user.getPhone());
    }

    if (user.getRoleTypeId() > 0) {
      sql.append("ROLETYPEID = ?, ");
      params.add(user.getRoleTypeId());
    }

    if (user.getAddress() != null) {
      sql.append("ADDRESS = ?, ");
      params.add(user.getAddress());
    }

    if (sql.charAt(sql.length() - 2) == ',') {
      sql.setLength(sql.length() - 2);
    }

    sql.append(" WHERE USERID = ?");
    params.add(userId);

    return new Binds(sql.toString(), params.toArray());
  }
  /**
   * Checks if the specified column exists in the given ResultSet.
   *
   * @param rs the ResultSet to check for the column
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
