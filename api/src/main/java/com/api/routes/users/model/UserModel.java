package com.api.routes.users.model;

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

  public UserModel setUserId(int userId, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.userId = userId;
    return this;
  }

  public String getNames() {
    return names;
  }

  public UserModel setNames(String names) {
    this.names = names;
    return this;
  }

  public UserModel setNames(String names, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.names = names;
    return this;
  }

  public String getSurNames() {
    return surNames;
  }

  public UserModel setSurNames(String surNames) {
    this.surNames = surNames;
    return this;
  }

  public UserModel setSurNames(String surNames, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.surNames = surNames;
    return this;
  }

  public int getDocumentTypeId() {
    return documentTypeId;
  }

  public UserModel setDocumentTypeId(int documentTypeId) {
    this.documentTypeId = documentTypeId;
    return this;
  }

  public UserModel setDocumentTypeId(int documentTypeId, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.documentTypeId = documentTypeId;
    return this;
  }

  public String getDocumentType() {
    return documentType;
  }

  public UserModel setDocumentType(String documentType) {
    this.documentType = documentType;
    return this;
  }

  public UserModel setDocumentType(String documentType, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.documentType = documentType;
    return this;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public UserModel setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public UserModel setDocumentNumber(String documentNumber, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.documentNumber = documentNumber;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public UserModel setEmail(String email, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserModel setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserModel setPassword(String password, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.password = password;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public UserModel setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public UserModel setPhone(String phone, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.phone = phone;
    return this;
  }

  public int getRoleTypeId() {
    return roleTypeId;
  }

  public UserModel setRoleTypeId(int roleTypeId) {
    this.roleTypeId = roleTypeId;
    return this;
  }

  public UserModel setRoleTypeId(int roleTypeId, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.roleTypeId = roleTypeId;
    return this;
  }

  public String getRoleType() {
    return roleType;
  }

  public UserModel setRoleType(String roleType) {
    this.roleType = roleType;
    return this;
  }

  public UserModel setRoleType(String roleType, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.roleType = roleType;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public UserModel setAddress(String address) {
    this.address = address;
    return this;
  }

  public UserModel setAddress(String address, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.address = address;
    return this;
  }

  public boolean getActive() {
    return active;
  }

  public UserModel setActive(boolean active) {
    this.active = active;
    return this;
  }

  public UserModel setActive(boolean active, boolean setValue) {
    if (!setValue) {
      return this;
    }
    this.active = active;
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
