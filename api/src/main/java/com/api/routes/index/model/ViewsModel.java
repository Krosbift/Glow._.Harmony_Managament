package com.api.routes.index.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewsModel {
  private Integer viewId;
  private String viewName;
  private String description;
  private boolean isActive;

  public Integer getViewId() {
    return viewId;
  }

  public ViewsModel setViewId(Integer viewId) {
    this.viewId = viewId;
    return this;
  }

  public ViewsModel setViewId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.viewId = rs.getInt("VIEWID");
    return this;
  }

  public String getViewName() {
    return viewName;
  }

  public ViewsModel setViewName(String viewName) {
    this.viewName = viewName;
    return this;
  }

  public ViewsModel setViewName(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.viewName = rs.getString("NAME");
    return this;
  }

  public String getDescription() {
    return description;
  }

  public ViewsModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public ViewsModel setDescription(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.description = rs.getString("DESCRIPTION");
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public ViewsModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public ViewsModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of ViewsModel.
   *
   * @return the current instance of ViewsModel
   */
  public ViewsModel build() {
    return this;
  }
}
