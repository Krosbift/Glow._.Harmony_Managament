package com.api.routes.users.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {
  private int userId;
  private String names;
  private String surNames;
  private int documentTypeId;
  private String documentType;
  private String documentNumber;
  private String email;
  private String password;
  private String phone;
  private int roleTypeId;
  private String roleType;
  private String address;
  private boolean active;

  public int getUserId() {
    return userId;
  }

  public UserModel setUserId(int userId) {
    this.userId = userId;
    return this;
  }

  public UserModel setUserId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.userId = rs.getInt("USERID");
    return this;
  }

  public String getNames() {
    return names;
  }

  public UserModel setNames(String names) {
    this.names = names;
    return this;
  }

  public UserModel setNames(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.names = rs.getString("NAMES");
    return this;
  }

  public String getSurNames() {
    return surNames;
  }

  public UserModel setSurNames(String surNames) {
    this.surNames = surNames;
    return this;
  }

  public UserModel setSurNames(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.surNames = rs.getString("SURNAMES");
    return this;
  }

  public int getDocumentTypeId() {
    return documentTypeId;
  }

  public UserModel setDocumentTypeId(int documentTypeId) {
    this.documentTypeId = documentTypeId;
    return this;
  }

  public UserModel setDocumentTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.documentTypeId = rs.getInt("DOCUMENTTYPEID");
    return this;
  }

  public String getDocumentType() {
    return documentType;
  }

  public UserModel setDocumentType(String documentType) {
    this.documentType = documentType;
    return this;
  }

  public UserModel setDocumentType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.documentType = rs.getString("DOCUMENTTYPE");
    return this;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public UserModel setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public UserModel setDocumentNumber(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.documentNumber = rs.getString("DOCUMENTNUMBER");
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public UserModel setEmail(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.email = rs.getString("EMAIL");
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserModel setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserModel setPassword(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.password = rs.getString("PASSWORD");
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public UserModel setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public UserModel setPhone(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.phone = rs.getString("PHONENUMBER");
    return this;
  }

  public int getRoleTypeId() {
    return roleTypeId;
  }

  public UserModel setRoleTypeId(int roleTypeId) {
    this.roleTypeId = roleTypeId;
    return this;
  }

  public UserModel setRoleTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.roleTypeId = rs.getInt("ROLETYPEID");
    return this;
  }

  public String getRoleType() {
    return roleType;
  }

  public UserModel setRoleType(String roleType) {
    this.roleType = roleType;
    return this;
  }

  public UserModel setRoleType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.roleType = rs.getString("ROLETYPE");
    return this;
  }

  public String getAddress() {
    return address;
  }

  public UserModel setAddress(String address) {
    this.address = address;
    return this;
  }

  public UserModel setAddress(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.address = rs.getString("ADDRESS");
    return this;
  }

  public boolean getActive() {
    return active;
  }

  public UserModel setActive(boolean active) {
    this.active = active;
    return this;
  }

  public UserModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.active = rs.getBoolean("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of UserModel.
   *
   * @return the current instance of UserModel
   */
  public UserModel build() {
    return this;
  }
}
