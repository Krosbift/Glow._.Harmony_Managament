package com.api.routes.index.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentTypesModel {
  private int documentTypeId;
  private String documentType;
  private String description;
  private boolean isActive;

  public int getDocumentTypeId() {
    return documentTypeId;
  }

  public DocumentTypesModel setDocumentTypeId(int documentTypeId) {
    this.documentTypeId = documentTypeId;
    return this;
  }

  public DocumentTypesModel setDocumentTypeId(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.documentTypeId = rs.getInt("DOCUMENTTYPEID");
    return this;
  }

  public String getDocumentType() {
    return documentType;
  }

  public DocumentTypesModel setDocumentType(String documentType) {
    this.documentType = documentType;
    return this;
  }

  public DocumentTypesModel setDocumentType(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.documentType = rs.getString("DOCUMENTTYPE");
    return this;
  }

  public String getDescription() {
    return description;
  }

  public DocumentTypesModel setDescription(String description) {
    this.description = description;
    return this;
  }

  public DocumentTypesModel setDescription(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.description = rs.getString("DESCRIPTION");
    return this;
  }

  public boolean isActive() {
    return isActive;
  }

  public DocumentTypesModel setActive(boolean isActive) {
    this.isActive = isActive;
    return this;
  }

  public DocumentTypesModel setActive(ResultSet rs, boolean setValue) throws SQLException {
    if (!setValue) {
      return this;
    }
    this.isActive = rs.getBoolean("ACTIVE");
    return this;
  }

  /**
   * Builds and returns the current instance of DocumentTypesModel.
   *
   * @return the current instance of DocumentTypesModel
   */
  public DocumentTypesModel build() {
    return this;
  }
}
