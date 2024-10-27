package com.api.routes.index.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleTypesModel {
  private int roleTypeId;
  private String roleType;
  private String description;
  private boolean isActive;

  public int getRoleTypeId() {
    return roleTypeId;
  }

  public RoleTypesModel setRoleTypeId(int roleTypeId) {
    this.roleTypeId = roleTypeId;
    return this;
  }

  public RoleTypesModel setRoleTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.roleTypeId = rs.getInt("ROLETYPEID");
    return this;
  }

  public String getRoleType() {
    return roleType;
  }

  public RoleTypesModel setRoleType(String roleType) {
    this.roleType = roleType;
    return this;
  }

  public RoleTypesModel setRoleType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.roleType = rs.getString("ROLETYPE");
    return this;
  }

  public String getDescription() {
    return description;
  }

  public RoleTypesModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleTypesModel setDescription(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.description = rs.getString("DESCRIPTION");
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public RoleTypesModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public RoleTypesModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of RoleTypesModel.
   *
   * @return the current instance of RoleTypesModel
   */
  public RoleTypesModel build() {
    return this;
  }
}
